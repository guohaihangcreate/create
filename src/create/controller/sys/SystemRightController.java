package create.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import create.model.system.Group;
import create.model.system.GroupRightRelation;
import create.model.system.Right;
import create.model.system.SysRole;
import create.service.system.RightGroupRelationService;
import create.service.system.RightGroupService;
import create.service.system.SysRightService;
import create.service.system.SysRoleService;

@Controller
@RequestMapping("/systemRightController")
public class SystemRightController extends MultiActionController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private SysRightService sysRightService;

	private SysRoleService sysRoleService;

	private RightGroupService rightGroupService;

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public RightGroupService getRightGroupService() {
		return rightGroupService;
	}

	@Autowired
	public void setRightGroupService(RightGroupService rightGroupService) {
		this.rightGroupService = rightGroupService;
	}

	@Autowired
	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public SysRightService getSysRightService() {
		return sysRightService;
	}

	@Autowired
	public void setSysRightService(SysRightService sysRightService) {
		this.sysRightService = sysRightService;
	}

	public RightGroupRelationService rightGroupRelationService;

	public RightGroupRelationService getRightGroupRelationService() {
		return rightGroupRelationService;
	}

	@Autowired
	public void setRightGroupRelationService(
			RightGroupRelationService rightGroupRelationService) {
		this.rightGroupRelationService = rightGroupRelationService;
	}

	@RequestMapping("/queryList")
	public String queryList(HttpServletRequest request) {
		HashMap paramMap = new HashMap();
		List<Right> sysRights = sysRightService
				.selectByProperyByParamMap(paramMap);
		request.setAttribute("sysRights", sysRights);
		return "system/querySysRightList";
	}

	@RequestMapping("/queryRightGroupRightList")
	public String queryRightGroupRightList(HttpServletRequest request) {
		Map paraMap = new HashMap();
		/*
		 * 查询所有的权限组
		 */
		List<Group> groups = rightGroupService.selectByGroupByParamMap(paraMap);
		/*
		 * 查询权限和权限组的关系表
		 */
		String ids = "";
		for (Group g : groups) {
			Map paraMap1 = new HashMap();
			paraMap1.put("tgId", g.getTgId());
			List<GroupRightRelation> groupRightRelations = rightGroupRelationService
					.selectByGroupRightRelationByMap(paraMap1);
			List<Right> sysRights = new ArrayList();
			for (GroupRightRelation gr : groupRightRelations) {
				// 去重复
				Map paraMap2 = new HashMap();
				paraMap2.put("trId", gr.getTrId());
				paraMap2.put("detail", request.getParameter("detail"));
				List<Right> rlist = sysRightService.selectByProperyByParamMap(paraMap2);
				if(rlist!=null&&rlist.size()>0){
					sysRights.add(rlist.get(0));
				}
				ids += gr.getTrId() + ",";
			}
			g.setSysRights(sysRights);
		}
		if (!"".equals(ids)) {
			ids = ids.substring(0, ids.lastIndexOf(","));
		}
		// 未分组的权限放入其他分组中
		Group p = new Group();
		p.setGroupName("其他");
		Map paraMap2 = new HashMap();
		paraMap2.put("ids", ids.split(","));
		p.setSysRights(sysRightService.findByIdsMap(paraMap2));
		groups.add(p);
		request.setAttribute("groups", groups);
		return "system/queryRightGroupRightList";
	}
	
	/*
	 *新增角色和权限关系表
	 */
	@RequestMapping("/saveRightGroupRef")
	public ModelAndView saveRightGroupRef(HttpServletRequest request) {
		String roleId = request.getParameter("roleId");
		String role_list = request.getParameter("right_list");
		if(role_list!=null){
			for(String rid:role_list.split(";")){
				GroupRightRelation grr = new GroupRightRelation();
				grr.setTgId(Integer.valueOf(roleId));
				grr.setTrId(Integer.valueOf(rid));
				grr.setRightType(0);
				rightGroupRelationService.insertGroupRightRelationSelective(grr);
			}
		}
		return new ModelAndView(
				"redirect:/systemRightController/queryRoleRefRightList.go?dateid="
						+ roleId);
	}
	
	
	/*
	 *新增角色和权限关系表
	 */
	@RequestMapping("/deleteRightInfoRefRole")
	public ModelAndView deleteRightInfoRefRole(HttpServletRequest request) {
		String roleId = request.getParameter("roleId");
		String ids = request.getParameter("ids");
		if(ids!=null){
			for(String rid:ids.split(",")){
				rightGroupRelationService.deleteByPrimaryKey(Integer.valueOf(rid));
			}
		}
		return new ModelAndView(
				"redirect:/systemRightController/queryRoleRefRightList.go?dateid="
						+ roleId);
	}
	
	
	
	@RequestMapping("/queryRoleRefRightList")
	public String queryRoleRefRightList(HttpServletRequest request) {
		String roleId = request.getParameter("dateid");
		if (roleId != null && !"".equals(roleId)) {
			SysRole role = this.sysRoleService.selectByPK(Integer
					.valueOf(roleId));
			request.setAttribute("role", role);
		}
		
		List rrights = new ArrayList();
		Map paraMap = new HashMap();
		paraMap.put("tgId",roleId);
		List<GroupRightRelation> grrs = rightGroupRelationService.selectByGroupRightRelationByMap(paraMap);
		for(GroupRightRelation grr:grrs){
			//根据id查询
			Right rt = sysRightService.selectByPK(grr.getTrId());
			//设置权限组ID，临时变量为了在列表中根据id删除
			if(rt!=null){
				rt.setGrrId(grr.getTgrId());
				rrights.add(rt);
			}
		}
		request.setAttribute("rrights", rrights);
		return "system/queryRoleRefRightList";
	}

	@RequestMapping("/toAddRightInfoPage")
	public String toAddRightInfoPage() {
		return "system/addRightInfo";
	}

	@RequestMapping("/saveRightInfo")
	public String saveRightInfo(Right right, HttpServletRequest request) {
		sysRightService.insertRight(right);
		return queryList(request);
	}

}
