package create.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.hrm.Treenodes;
import create.model.system.RoleRightRelation;
import create.model.system.RoleTreeNodeRelation;
import create.model.system.SysRole;
import create.model.system.UserGroupRelation;
import create.service.system.RoleRightRelationService;
import create.service.system.RoleRightService;
import create.service.system.RoleTreeNodeRelationService;
import create.service.system.SysRoleService;
import create.service.system.TreeNodeService;
import create.service.system.UserGroupRelationService;

@Controller
@RequestMapping("/sysRoleController")
public class SystemRoleController extends BaseController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private SysRoleService sysRoleService;

	private RoleRightService roleRightService;

	private RoleRightRelationService roleRightRelationService;
	
	private TreeNodeService treeNodeService;

	public TreeNodeService getTreeNodeService() {
		return treeNodeService;
	}

	@Autowired
	public void setTreeNodeService(TreeNodeService treeNodeService) {
		this.treeNodeService = treeNodeService;
	}

	private UserGroupRelationService userGroupRelationService;

	public UserGroupRelationService getUserGroupRelationService() {
		return userGroupRelationService;
	}

	@Autowired
	public void setUserGroupRelationService(
			UserGroupRelationService userGroupRelationService) {
		this.userGroupRelationService = userGroupRelationService;
	}

	private RoleTreeNodeRelationService roleTreeNodeRelationService;

	public RoleTreeNodeRelationService getRoleTreeNodeRelationService() {
		return roleTreeNodeRelationService;
	}

	@Autowired
	public void setRoleTreeNodeRelationService(
			RoleTreeNodeRelationService roleTreeNodeRelationService) {
		this.roleTreeNodeRelationService = roleTreeNodeRelationService;
	}

	public RoleRightService getRoleRightService() {
		return roleRightService;
	}

	@Autowired
	public void setRoleRightService(RoleRightService roleRightService) {
		this.roleRightService = roleRightService;
	}

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	@Autowired
	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	@RequestMapping("/querySysRole")
	public ModelAndView querySysRole(HttpServletRequest request) {
		String roleId = request.getParameter("roleId");
		if (roleId != null && !"".equals(roleId)) {
			SysRole role = this.sysRoleService.selectByPK(Integer
					.valueOf(roleId));
			request.setAttribute("role", role);
		}
		return new ModelAndView("redirect:/sysRoleController/queryList.go");
	}

	// 查询角色
	@RequestMapping("/queryRoleRefTags")
	public String queryRoleRefTags(HttpServletRequest request) {
		return "system/querySysRoleRef_tags";
	}

	// 查询角色
	@RequestMapping("/queryList")
	public String queryList(HttpServletRequest request, SysRole role) {
		String pageNow = request.getParameter("pageNow");
		Map<String, Object> params = new HashMap<String, Object>();
		// 获取总条数
		Long totalCount = this.sysRoleService.pageCounts(params);
		// 设置分页对象
		Page page = executePage(request, totalCount);
		// 设置分页页面信息
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEndinIndex());
		// 如排序
		if (page.isSort()) {
			params.put("orderName", page.getSortName());
			params.put("descAsc", page.getSortState());
		} else {
			// 没有进行排序,默认排序方式
			params.put("orderName", "age");
			params.put("descAsc", "asc");
		}
		List<SysRole> sysRoles = sysRoleService.selectByPropery(role);
		// 查询角色下的成员数量
		for (SysRole s : sysRoles) {
			Map hashMap = new HashMap();
			hashMap.put("tgId", s.getRoleId());
			List<UserGroupRelation> user_relations = userGroupRelationService
					.selectByUserGroupRelationByParamMap(hashMap);
			if (user_relations != null) {
				s.setUser_member(user_relations.size());
			}
		}
		request.setAttribute("sysRoles", sysRoles);
		return "system/querySysRoleList";
	}

	@RequestMapping("/toProcessRoleInfoPage")
	public String toProcessRoleInfoPage(@RequestParam("dateid")
	String dateid, String opt_type, HttpServletRequest request) {
		SysRole trole = null;
		if (dateid != null && !"".equals(dateid)) {
			trole = sysRoleService.selectByPK(Integer.valueOf(dateid));
		}
		request.setAttribute("trole", trole);
		request.setAttribute("opt_type", opt_type);// 为查看权限
		return "system/seeOrEditeRoleInfo";
	}

	/*
	 * 删除角色关联的人员
	 */
	@RequestMapping("/deleteoleInfoRefUser")
	public ModelAndView deleteoleInfoRefUser(SysRole role,
			HttpServletRequest request, HttpServletResponse response) {
		// 角色和成员关系表
		Map paraMap = new HashMap();
		for (String id : request.getParameter("ids").split(",")) {
			if (id != null && !"".equals(id)) {
				// 更新角色和成员关系表
				paraMap.put("tgId", role.getRoleId());
				paraMap.put("tuId", Integer.valueOf(id));
				userGroupRelationService.deleteByProperyMap(paraMap);
			}
		}
		return new ModelAndView(
				"redirect:/userController/queryRoleUpUser.go?dateid="
						+ role.getRoleId());
	}

	/*
	 * 角色和成员关系表
	 */
	@RequestMapping("/updateRoleInfoRefUser")
	public ModelAndView updateRoleInfoRefUser(SysRole role, HttpServletRequest request) {
		// 角色和成员关系表
		String role_list = request.getParameter("role_list");
		String[] rlist = role_list.split(";");
		// 更新角色和成员关系表
		// userGroupRelationService.deleteByRoleID(role.getRoleId());
		String[] users = role_list.split(",");
		UserGroupRelation userGroupRelation = null;
		for (String userId : rlist) {
			userGroupRelation = new UserGroupRelation();
			userGroupRelation.setTgId(role.getRoleId());
			userGroupRelation.setTuId(Integer.valueOf(userId.split(",")[0]));
			this.userGroupRelationService
					.insertUserGroupRelation(userGroupRelation);
		}
		return new ModelAndView(
				"redirect:/userController/queryRoleUpUser.go?dateid="
						+ role.getRoleId());
	}

	/*
	 * 角色和菜单关系表
	 */
	@RequestMapping("/updateRoleInfoRefMenue")
	public String updateRoleInfoRefMenue(SysRole role,
			HttpServletRequest request) {
		// 角色和菜单关系表
		String aoth_list = request.getParameter("aoth_list");
		String[] aoth = aoth_list.split(";");
		RoleTreeNodeRelation roleTreeNodeRelation = null;
		// 更新角色和菜单表
		roleTreeNodeRelationService.deleteByRoleID(role.getRoleId());
		for (String a : aoth) {
			String id = a.split(",")[0];
			roleTreeNodeRelation = new RoleTreeNodeRelation();
			roleTreeNodeRelation.setRoleid(role.getRoleId());
			roleTreeNodeRelation.setTreenodeid(Integer.valueOf(id));
			roleTreeNodeRelationService
					.insertRoleTreeNodeRelation(roleTreeNodeRelation);
		}

		// 角色和权限关系表
		String rightlist = role.getRight_list();
		String[] right_list = rightlist.split(",");
		RoleRightRelation roleRightRelation = null;
		// 更新角色和权限表
		roleRightService.deleteByRoleID(role.getRoleId());
		for (String right : right_list) {
			if (right != null && !"".equals(right)) {
				roleRightRelation = new RoleRightRelation();
				roleRightRelation.setRightId(Integer
						.valueOf(right.split(",")[0]));
				roleRightRelation.setRoleId(role.getRoleId());
				roleRightService.insertSelective(roleRightRelation);
			}
		}
		return "system/querySysRoleRef_tags";
	}

	/*
	 * 角色和权限关系表
	 */
	@RequestMapping("/updateRoleInfoRefRight")
	public ModelAndView updateRoleInfoRefRight(SysRole role,
			HttpServletRequest request) {
		// 角色和权限关系表
		String rightlist = request.getParameter("rightlist");
		String[] right_list = rightlist.split(",");
		RoleRightRelation roleRightRelation = null;
		// 更新角色和权限表
		roleRightService.deleteByRoleID(role.getRoleId());
		for (String right : right_list) {
			if (right != null && !"".equals(right)) {
				roleRightRelation = new RoleRightRelation();
				roleRightRelation.setRightId(Integer
						.valueOf(right.split(",")[0]));
				roleRightRelation.setRoleId(role.getRoleId());
				roleRightService.insertSelective(roleRightRelation);
			}
		}
		return new ModelAndView("redirect:/sysRoleController/queryList.go");
	}
	
	
	/*
	 * 保存角色和菜单的关系表
	 */
	@RequestMapping("/saveRoleInfoRefMenue")
	public ModelAndView saveRoleInfoRefMenue(RoleTreeNodeRelation roleTreeNodeR,
			HttpServletRequest request) {
		// 角色和权限关系表
		String menueId = request.getParameter("menueId");
		String[] menue_list = menueId.split(",");
		RoleTreeNodeRelation  rtr = null;
		roleTreeNodeRelationService.deleteByRoleID(roleTreeNodeR.getRoleid());
		for (String mId : menue_list) {
			if (mId != null && !"".equals(mId)) {
				rtr = new RoleTreeNodeRelation();
				rtr.setTreenodeid(Integer.valueOf(mId));
				rtr.setRoleid(roleTreeNodeR.getRoleid());
				roleTreeNodeRelationService.insertRoleTreeNodeRelation(rtr);
				/*
				 * 查询pid存在则不新增,不存在新增pid
				 */
				Treenodes td = treeNodeService.selectByPrimaryKey(Integer.valueOf(mId));
				RoleTreeNodeRelation prtr = null;
				HashMap paraMap = new HashMap();
				paraMap.put("treenodeid", td.getPid());
				paraMap.put("roleid", roleTreeNodeR.getRoleid());
				List<RoleTreeNodeRelation> rtrs =roleTreeNodeRelationService.getRoleTreeNodeRelationByMap(paraMap);
				if(rtrs==null||rtrs.size()<=0){
					prtr = new RoleTreeNodeRelation();
					prtr.setTreenodeid(td.getPid());
					prtr.setRoleid(roleTreeNodeR.getRoleid());
					roleTreeNodeRelationService.insertRoleTreeNodeRelation(prtr);
				}
				
			}
		}
		return new ModelAndView("redirect:/treeNodeController/queryRoleTreeNode.go?roleId="+roleTreeNodeR.getRoleid());
	}
	

	@RequestMapping("/toAddRoleInfoPage")
	public String toAddRoleInfoPage() {
		return "system/addSysRoleInfo";
	}

	@RequestMapping("/toSaveRoleInfo")
	public ModelAndView saveSysRoleInfo(SysRole role, HttpServletRequest request) {
		if (role.getParentTrId() == null) {
			role.setParentTrId(Integer.valueOf(0));
		}
		sysRoleService.insertRole(role);
		if (role != null && role.getRole_list() != null) {
			String rolelist = role.getRole_list();
			String[] users = rolelist.split(",");
			UserGroupRelation userGroupRelation = null;
			for (String userId : users) {
				userGroupRelation = new UserGroupRelation();
				userGroupRelation.setTugId(role.getRoleId());
				userGroupRelation.setTuId(Integer.valueOf(userId));
				this.userGroupRelationService
						.insertUserGroupRelation(userGroupRelation);
			}
		}
		return new ModelAndView("redirect:/sysRoleController/queryList.go");
	}

	public RoleRightRelationService getRoleRightRelationService() {
		return roleRightRelationService;
	}

	@Autowired
	public void setRoleRightRelationService(
			RoleRightRelationService roleRightRelationService) {
		this.roleRightRelationService = roleRightRelationService;
	}

}
