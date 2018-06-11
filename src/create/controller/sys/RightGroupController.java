package create.controller.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.util.UtilCommon;

import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.hrm.User;
import create.model.system.Group;
import create.model.system.GroupRightRelation;
import create.model.system.Right;
import create.service.system.RightGroupRelationService;
import create.service.system.RightGroupService;
import create.service.system.SysRightService;

@Controller
@RequestMapping("/rightGroupController")
public class RightGroupController extends BaseController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	private SysRightService sysRightService;

	public RightGroupService rightGroupService;

	public RightGroupRelationService rightGroupRelationService;

	public RightGroupService getRightGroupService() {
		return rightGroupService;
	}

	@Autowired
	public void setRightGroupService(RightGroupService rightGroupService) {
		this.rightGroupService = rightGroupService;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/updaterightGroupRelation")
	public ModelAndView updaterightGroupRelation(HttpServletRequest request) {
		HashMap paramap = new HashMap();
		paramap.put("trid", request.getParameter("trId"));
		paramap.put("right_type", 1);
		rightGroupRelationService.updateRightGroupRelationMap(paramap);
		return new ModelAndView(
				"redirect:/rightGroupController/queryGroupAndRelationRight.go?groupId="
						+ request.getParameter("tg_id"));
	}

	@RequestMapping("/saveGroup")
	public ModelAndView saveGroup(Group group, HttpServletRequest request) {
		HttpSession sessionMap = request.getSession(true);
		group.setCreateby((Integer) sessionMap.getAttribute("userID"));
		// 修改日期
		group.setCreatetime(newData);
		rightGroupService.insertGroupSelective(group);
		return new ModelAndView(
				"redirect:/rightGroupController/queryGroupList.go?groupId");
	}

	@RequestMapping("/queryGroupList")
	public String queryGroupList(Group group, HttpServletRequest request) {
		int all_right_num = 0;
		HashMap paramMap = new HashMap();
		List<Group> groups = rightGroupService
				.selectByGroupByParamMap(paramMap);
		// 权限组下面的权限数量
		HashMap paraMap = new HashMap();
		for (Group g : groups) {
			paraMap.put("tgId", g.getTgId());
			Integer right_num = rightGroupRelationService
					.belongRightCounts(paraMap);
			g.setRight_num(right_num);
			all_right_num += right_num;
		}
		request.setAttribute("all_right_num", all_right_num);
		request.setAttribute("groups", groups);
		return "system/RightGroupRightList";
	}

	@RequestMapping("/queryGroupAndRelationRight")
	public String queryGroupAndRelationRight(HttpServletRequest request) {
		String tgId = request.getParameter("groupId");
		Group group = null;
		HashMap paraMap = new HashMap();
		if (tgId != null && !"".equals(tgId)) {
			group = rightGroupService.selectByPrimaryKey(Integer.valueOf(tgId));
			request.setAttribute("group", group);
		}
		paraMap.put("right_type", 0);
		// 查询权限组下的权限
		if (group != null && group.getTgId() != null) {
			paraMap.put("tg_id", group.getTgId());
		}
		paraMap.put("detail", request.getParameter("detail"));
		List<Right> group_rights = sysRightService
				.selectByProperyByParamMap(paraMap);
		request.setAttribute("group_rights", group_rights);
		// 查询权限组下的权限
		return "system/groupAndRelationRight";
	}

	@RequestMapping("/saveGroupRelationRight")
	public ModelAndView saveGroupRelationRight(HttpServletResponse response,
			GroupRightRelation groupRightRelation, HttpServletRequest request) {

		HttpSession sessionMap = request.getSession(true);
		groupRightRelation.setCreateby((Integer) sessionMap
				.getAttribute("userID"));
		groupRightRelation.setCreatetime(newData);
		groupRightRelation.setRightType(0);
		rightGroupRelationService
				.insertGroupRightRelationSelective(groupRightRelation);
		return new ModelAndView(
				"redirect:/rightGroupController/queryGroupAndRelationRight.go?groupId="
						+ request.getParameter("groupId"));
	}

	@RequestMapping(value = "/checkGroupRelationRight")
	@ResponseBody
	public void checkGroupRelationRight(HttpServletRequest request,
			HttpServletResponse response, GroupRightRelation groupRightRelation) {
		String str = "";
		HashMap paramap = new HashMap();
		paramap.put("tgId", groupRightRelation.getTgId());
		paramap.put("trId", groupRightRelation.getTrId());
		List<GroupRightRelation> groupRightRelations = rightGroupRelationService
				.selectByGroupRightRelationByMap(paramap);
		if (groupRightRelations != null && groupRightRelations.size() > 0) {
			str += "\"num\":\"" + groupRightRelations.size() + "\"";
			try {
				UtilCommon.reponse(request, response, str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/saveRirht")
	public ModelAndView saveRirht(Right right, HttpServletRequest request) {
		HttpSession sessionMap = request.getSession(true);
		right.setCreateby((Integer) sessionMap.getAttribute("userID"));
		right.setParentTrId(-1);
		// 修改日期
		right.setGenTime(newData);
		sysRightService.insertRight(right);
		return new ModelAndView(
				"redirect:/rightGroupController/queryRghtList.go");
	}

	@RequestMapping("/saveRirhtDetail")
	public ModelAndView saveRirhtDetail(Right right, HttpServletRequest request) {
		HttpSession sessionMap = request.getSession(true);
		right.setCreateby((Integer) sessionMap.getAttribute("userID"));
		// 修改日期
		right.setGenTime(newData);
		sysRightService.insertRight(right);
		return new ModelAndView(
				"redirect:/rightGroupController/queryRghtDetailList.go");
	}

	@RequestMapping("/toUpdateRirhtDetail")
	public String toUpdateRirhtDetail(HttpServletRequest request) {
		Right right = null;
		String trId = request.getParameter("trId");
		if (trId != null && !"".equals(trId)) {
			right = sysRightService.selectByPK(Integer.valueOf(trId));
			if (right != null && right.getParentTrId() != null) {
				right.setBelong_right(sysRightService.selectByPK(
						right.getParentTrId()).getRightName());
			}
			request.setAttribute("right", right);
		}

		return "system/to_update_addRightDetailInfo";
	}

	@RequestMapping("/deleteRirht")
	public ModelAndView deleteRirht(HttpServletRequest request) {
		Right right = null;
		String trId = request.getParameter("trId");
		if (trId != null && !"".equals(trId)) {
			sysRightService.deleteByPrimaryKey(Integer.valueOf(trId));
		}
		return new ModelAndView(
				"redirect:/rightGroupController/queryRghtList.go");
	}

	@RequestMapping("/toUpdateRirht")
	public String toUpdateRirht(HttpServletRequest request) {
		Right right = null;
		String trId = request.getParameter("trId");
		if (trId != null && !"".equals(trId)) {
			right = sysRightService.selectByPK(Integer.valueOf(trId));
			request.setAttribute("right", right);
		}

		return "system/to_update_addRight";
	}

	@RequestMapping("/updateRirht")
	public ModelAndView updateRirht(Right right, HttpServletRequest request) {
		sysRightService.updateRightInfo(right);
		return new ModelAndView(
				"redirect:/rightGroupController/queryRghtList.go");
	}

	@RequestMapping("/updateRirhtDetail")
	public ModelAndView updateRirhtDetail(Right right,
			HttpServletRequest request) {
		sysRightService.updateRightInfo(right);
		return new ModelAndView(
				"redirect:/rightGroupController/queryRghtDetailList.go");
	}

	@RequestMapping("/queryRghtDetailList")
	public String queryRghtDetailList(Right right, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String pageNow = request.getParameter("pageNow");
		// =-1表示为权限节点，！= null为权限详细节点
		if (right != null
				&& ("".equals(right.getParentTrId()) || right.getParentTrId() == null)) {
			params.put("detail", "detail");
		}
		if (right != null && right.getRightName() != null
				&& !"".equals(right.getRightName())) {
			params.put("rightName", right.getRightName());
		}
		if (right != null && right.getDescription() != null
				&& !"".equals(right.getDescription())) {
			params.put("description", right.getDescription());
		}
		if (right != null && right.getTrMark() != null
				&& !"".equals(right.getTrMark())) {
			params.put("trMark", right.getTrMark());
		}
		if (right != null && right.getParentTrId() != null
				&& !"".equals(right.getParentTrId())) {
			params.put("parentTrId", right.getParentTrId());
		}
		// 获取总条数
		Long totalCount = this.sysRightService.pageCounts(params);
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
		request.setAttribute("page", page);
		List<Right> listRight = sysRightService
				.selectByProperyByParamMap(params);
		// 查询条件中所属权限选项
		Map<String, Object> par = new HashMap<String, Object>();
		par.put("startIndex", page.getBeginIndex());
		par.put("endIndex", page.getEndinIndex());
		par.put("parentTrId", -1);
		List<Right> right_query = sysRightService
				.selectByProperyByParamMap(par);
		request.setAttribute("right_query", right_query);

		for (Right rt : listRight) {
			if(rt.getParentTrId()!=null){
				rt.setBelong_right(sysRightService.selectByPK(rt.getParentTrId())
						.getRightName());
			}
		}
		request.setAttribute("listRight", listRight);
		return "system/RightWriteList";
	}

	@RequestMapping("/queryRghtList")
	public String queryRghtList(Right right, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String pageNow = request.getParameter("pageNow");
		// =-1表示为权限节点，！=-1为权限详细节点
		params.put("detail",request.getParameter("detail"));
		params.put("rightName", right.getRightName());
		params.put("description", right.getDescription());
		params.put("trMark", right.getTrMark());
		// 获取总条数
		Long totalCount = this.sysRightService.pageCounts(params);
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
		List<Right> listRight = sysRightService
				.selectByProperyByParamMap(params);
		request.setAttribute("listRight", listRight);
		String type = (String) request.getParameter("type");
		if (type != null && "select".equals(type)) {
			return "system/RightDeailWriteSelect";
		} else {
			return "system/RightDeailWriteList";
		}
	}

	public SysRightService getSysRightService() {
		return sysRightService;
	}

	@Autowired
	public void setSysRightService(SysRightService sysRightService) {
		this.sysRightService = sysRightService;
	}

	public RightGroupRelationService getRightGroupRelationService() {
		return rightGroupRelationService;
	}

	@Autowired
	public void setRightGroupRelationService(
			RightGroupRelationService rightGroupRelationService) {
		this.rightGroupRelationService = rightGroupRelationService;
	}

}
