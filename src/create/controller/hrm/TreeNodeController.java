package create.controller.hrm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import system.util.StringUtils;
import system.util.StringUtils_;
import system.util.UtilCommon;
import create.model.hrm.Treenodes;
import create.model.hrm.User;
import create.model.system.RoleTreeNodeRelation;
import create.model.system.SysRole;
import create.service.system.RoleTreeNodeRelationService;
import create.service.system.TreeNodeService;

@Controller
@RequestMapping("/treeNodeController")
public class TreeNodeController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private RoleTreeNodeRelationService roleTreeNodeRelationService;

	public RoleTreeNodeRelationService getRoleTreeNodeRelationService() {
		return roleTreeNodeRelationService;
	}

	@Autowired
	public void setRoleTreeNodeRelationService(
			RoleTreeNodeRelationService roleTreeNodeRelationService) {
		this.roleTreeNodeRelationService = roleTreeNodeRelationService;
	}

	private TreeNodeService treeNodeService;

	public TreeNodeService getTreeNodeService() {
		return treeNodeService;
	}

	@Autowired
	public void setTreeNodeService(TreeNodeService treeNodeService) {
		this.treeNodeService = treeNodeService;
	}

	@RequestMapping(value = "/brogressBar", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void brogressBar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 下面设置Content-Type:application/x-javascript
		// 是为了适应Webkit的浏览器(chrome,safari)
		response.setHeader("Content-Type", "application/x-javascript");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		int count = 101; // 处理6条数据
		for (int i = 1; i < count; i++) {
			PrintWriter out = response.getWriter();
			// 处理完毕一条，输出结果到客户端
			out.println("已经执行" + i + "%");
			out.flush();
			// 这里假设每条数据处理时间为1秒

		}
	}

	@RequestMapping("/addTreeNode")
	public String addTreeNode(@RequestParam("icons")
	MultipartFile file, HttpServletRequest request, Treenodes treenodes) {
		String type = request.getParameter("type");
		try {
			if (treenodes.getPid() == null) {
				if (treenodes.getId() != null) {
					treenodes.setPid(treenodes.getId());
				} else {
					treenodes.setPid(Integer.valueOf(0));
				}
			}
			treenodes.setId(null);
			treenodes.setType(Integer.valueOf(type));
			treeNodeService.insertTreenodes(treenodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/menuesEdite";
	}

	/*
	 * 查询角色的菜单
	 */
	@RequestMapping("/queryRoleTreeNode")
	public String queryRoleTreeNode(HttpServletRequest request,
			Treenodes treenodes) {
		try {
			List<Treenodes> userMenus = new ArrayList();
			String roleID = request.getParameter("roleId");
			Treenodes trenodes = null;
			List<RoleTreeNodeRelation> rtrns = roleTreeNodeRelationService
					.findTreenodes(Integer.valueOf(roleID));
			for (int i = 0; i < rtrns.size(); i++) {
				Treenodes treenode = treeNodeService.selectByPrimaryKey(rtrns
						.get(i).getTreenodeid());
				userMenus.add(treenode);
			}

			// 查询pid=0的菜单数据
			List<Treenodes> allreenodes = treeNodeService.selectByPid(0);
			for (Treenodes t : allreenodes) {
				Integer tid = t.getId();
				// 查询子节点
				List<Treenodes> sunTreeNodes = treeNodeService.selectByPid(t
						.getId());
				t.setSunTreeNodes(sunTreeNodes);
			}
			// 选择角色已经分配的已有权限
			for (Treenodes t : userMenus) {
				if(t!=null){
					int tid = t.getId();
					for (Treenodes tt : allreenodes) {
						if(tt!=null){
							int ttid = tt.getId();
							if (ttid == tid) {
								tt.setSelected(1);
								continue;
							}else{
								for (Treenodes ttt : tt.getSunTreeNodes()){
									if (tid == ttt.getId()) {
										ttt.setSelected(1);
										continue;
									}
								}
							}
						}
					}
				}
			}
			request.setAttribute("allreenodes", allreenodes);
			request.setAttribute("roleID", roleID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/roleTreeNodeSelected";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/leftTreeNode")
	public String leftTreeNode(HttpServletRequest request, Treenodes treenodes) {
		try {
			List<Treenodes> userMenus = new ArrayList();
			User user = (User) request.getSession(true).getAttribute("user");
			List<SysRole> currentRoles = (List<SysRole>) request.getSession(
					true).getAttribute("currentRoles");
			// 构建角色所属菜单
			Treenodes trenodes = null;
			// 查询角色对应的菜单
			for (SysRole role : currentRoles) {
				List<RoleTreeNodeRelation> rtrns = roleTreeNodeRelationService
						.findTreenodes(role.getRoleId());
				for (int i = 0; i < rtrns.size(); i++) {
					// 查询有叶子结点的节点
					trenodes = treeNodeService.selectByPrimaryKeyAndPid(rtrns
							.get(i).getTreenodeid());
					if (trenodes != null) {
						Map paraMap = new HashMap();
						paraMap.put("pid", trenodes.getId());
						paraMap.put("roleId", role.getRoleId());
						List<Treenodes> listTreeNodes = treeNodeService
								.selectTreenodesByMap(paraMap);
						trenodes.setSunTreeNodes(listTreeNodes);
						userMenus.add(trenodes);
					}

				}

			}
			//去除重複權限
		      for  ( int i=0; i<userMenus.size()-1;i ++ )   { 
		    	    for  ( int  j=userMenus.size()-1 ;j>i;j--)   { 
		    	      if  (userMenus.get(j).getId()==userMenus.get(i).getId())   { 
		    	    	  userMenus.remove(j); 
		    	      } 
		    	    } 
		    	  } 
			
			request.setAttribute("userMenus", userMenus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/bootstrap_leftmenu";
	}

	@RequestMapping("/editeTreeNode")
	public String editeTreeNode(@RequestParam("icons")
	MultipartFile file, HttpServletRequest request, Treenodes treenodes) {
		try {
			treeNodeService.editeTreeNodes(treenodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/menuesEdite";
	}

	@RequestMapping("/deleteTreeNode")
	public String deleteTreeNode(HttpServletRequest request, Treenodes treenodes) {
		try {
			treeNodeService.deleteTreeNodes(treenodes.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/menuesEdite";
	}

	@RequestMapping(value = "/queryAllTreeNodes")
	@ResponseBody
	public void queryAllTreenodes(HttpServletRequest request,
			HttpServletResponse response, String id, String name) {
		String pId = request.getParameter("id");
		String pName = StringUtils_.chineseStrUTF8(request.getParameter("n"));
		String str = null;
		if (pId == null) {
			pId = "0";
		}
		str = treeNodeService.getChild(pId);
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/easyUiTreeData")
	@ResponseBody
	public void easyUiTreeData(HttpServletRequest request,
			HttpServletResponse response, String id, String name) {
		String str = null;
		str = treeNodeService.selectEasyUiDateTree("");
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reponse(HttpServletRequest request,
			HttpServletResponse response, Object msg) throws Exception {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(msg.toString());
		out.flush();
		out.close();
	}

}
