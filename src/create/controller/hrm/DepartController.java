package create.controller.hrm;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import system.util.UtilCommon;
import system.util.http.HttpUtils;
import test.ReadPropertity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import create.model.hrm.Depart;
import create.model.hrm.User;
import create.model.system.CompanyInfo;
import create.service.hrm.CompanyInfoService;
import create.service.hrm.DepartService;
import org.apache.log4j.Logger;
import create.service.hrm.UserService;
import test.dingTalk.DingTalkService;

@Controller
@RequestMapping("/deptController")
public class DepartController {

	protected final Logger logger = Logger.getLogger(this.getClass());

	private DepartService departmentService;

	private CompanyInfoService companyInfoService;

	private UserService userService;
	
	String accessTokenUrl;
    String corpid;
    String secret;
    String access_token;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private Depart depart;

	private CompanyInfo companyInfo;

	List<Depart> departs = null;

	@RequestMapping("/showdeparts")
	public String showDeptments(Depart dept, Map<String, Object> model) {
		departs = departmentService.searchDepartByProperty(dept);
		model.put("departs", departs);
		return "hrm/dept_list";
	}

	@RequestMapping("/queryDepartList")
	public String queryDepartList(Depart dept, HttpServletRequest request) {
		departs = departmentService.searchDepartByProperty(dept);
		request.setAttribute("departs", departs);
		return "hrm/dept_list";
	}

	@RequestMapping("/editedept")
	public String editedept(Depart dept, HttpServletRequest request) {
		try {
			//本系统修改部门信息
			int upstate = departmentService.updateDepart(dept);
			//关联钉钉ID
			if(upstate>0&&dept!=null&&dept.getDingtalkId()!=null){
//				柯锐特互动
//				修改完成以后同步更新修改钉钉中部门信息
				if("3".equals(dept.getYl1())){
					corpid = ReadPropertity.getProperty("create_hd_corpid");
			        secret = ReadPropertity.getProperty("create_hd_secret");
				}
//				柯锐特信息技术
				if("1".equals(dept.getYl1())){
					corpid = ReadPropertity.getProperty("create_corpid");
			        secret = ReadPropertity.getProperty("create_secret");
				}
				accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
		        access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
		       if(!"".equals(corpid)&&!"".equals(secret)){
		    	    JSONObject jsonobject_post = new JSONObject();
			        jsonobject_post.put("id", dept.getDingtalkId());
			        jsonobject_post.put("name", dept.getDeptName());
//			        jsonobject_post.put("parentid", dept.getYl1());
			        HttpUtils httpUtils = new HttpUtils();
					String result = httpUtils.doPost("https://oapi.dingtalk.com/department/update?access_token="+access_token, jsonobject_post, "UTF-8");
					JSONObject resutJSON = JSONObject.parseObject(result);
					resutJSON = JSON.parseObject(result);
					int msg = 1;
					if(resutJSON.get("errcode")!=null){
						 msg = Integer.valueOf((resutJSON.get("errcode").toString()));
					}
					
					String errmsg = (String)resutJSON.get("errmsg");
			        if(msg==0&&"updated".equals(errmsg)){
			            System.out.println("已经同步更新钉钉");
			        }
		       }
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/dept_list";
	}

	@RequestMapping("/adddept")
	public String adddept(Depart dept, HttpServletRequest request) {
		try {
//			柯锐特互动
//			修改完成以后同步更新修改钉钉中部门信息
			if("3".equals(dept.getYl1())){
				corpid = ReadPropertity.getProperty("create_hd_corpid");
		        secret = ReadPropertity.getProperty("create_hd_secret");
			}
//			柯锐特信息技术
			if("1".equals(dept.getYl1())){
				corpid = ReadPropertity.getProperty("create_corpid");
		        secret = ReadPropertity.getProperty("create_secret");
			}
			accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
	        access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
	       if(!"".equals(corpid)&&!"".equals(secret)){
	    	    JSONObject jsonobject_post = new JSONObject();
		        jsonobject_post.put("id", dept.getDingtalkId());
		        jsonobject_post.put("name", dept.getDeptName());
		        jsonobject_post.put("parentid", "1");
		        jsonobject_post.put("sourceIdentifier", dept.getDeptMak());
		        HttpUtils httpUtils = new HttpUtils();
				String result = httpUtils.doPost("https://oapi.dingtalk.com/department/create?access_token="+access_token, jsonobject_post, "UTF-8");
				JSONObject resutJSON = JSONObject.parseObject(result);
				resutJSON = JSON.parseObject(result);
				int msg = 1;
				if(resutJSON.get("errcode")!=null){
					 msg = Integer.valueOf((resutJSON.get("errcode").toString()));
				}
				
				String errmsg = (String)resutJSON.get("errmsg");
		        if(msg==0){
		            System.out.println("已经同步新增数据到钉钉中");
		            String dingtalkID = resutJSON.get("id").toString();
		            dept.setDingtalkId(dingtalkID);
		        }else{
		        	System.out.println(errmsg);
		        }
		        
	       }
	       //本系统新增部门
	        departmentService.inDepartUser(dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/dept_list";
	}

	@RequestMapping("/deleteDept")
	public String deleteDept(Depart dept, HttpServletRequest request) {
		try {
			departmentService.deleteByPrimaryKey(dept.getDeptId());
			
			if("3".equals(dept.getYl1())){
				corpid = ReadPropertity.getProperty("create_hd_corpid");
		        secret = ReadPropertity.getProperty("create_hd_secret");
			}
//			柯锐特信息技术
			if("1".equals(dept.getYl1())){
				corpid = ReadPropertity.getProperty("create_corpid");
		        secret = ReadPropertity.getProperty("create_secret");
			}
			accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
	        access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
	       if(!"".equals(corpid)&&!"".equals(secret)){
		        HttpUtils httpUtils = new HttpUtils();
				String result = httpUtils.doGet("https://oapi.dingtalk.com/department/delete?access_token="+access_token+"&id="+dept.getDingtalkId());
				JSONObject resutJSON = JSONObject.parseObject(result);
				resutJSON = JSON.parseObject(result);
				int msg = 1;
				if(resutJSON.get("errcode")!=null){
					 msg = Integer.valueOf((resutJSON.get("errcode").toString()));
				}
				
				String errmsg = (String)resutJSON.get("errmsg");
		        if(msg==0){
		            System.out.println("已经同步删除钉中的部门数据");
		        }else{
		        	System.out.println(errmsg);
		        }
		} }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/dept_list";
	}

	@RequestMapping(value = "/getAjaxDATA")
	@ResponseBody
	public void getAjaxDATA(HttpServletRequest request,
			HttpServletResponse response, String id, String name) {
		String str = "";
		if (id != null && !"".equals(id)) {
			String[] queryData = id.split(",");
			String queryType = queryData[1];
			// 0表示查询公司
			if ("0".equals(queryType)) {
				companyInfo = this.companyInfoService
						.selectByPrimaryKey(Integer.valueOf(queryData[0]));
				str = "{";
				if (companyInfo != null && companyInfo.getCompanyid() != null) {
					str += "\"id\":\"" + companyInfo.getCompanyid() + "\"";
				}
				if (companyInfo != null && companyInfo.getCompanyid() != null) {
					str += ",\"companyname\":\"" + companyInfo.getCompanyname()
							+ "\"";
				}
				if (companyInfo != null && companyInfo.getCompanymark() != null) {
					str += ",\"companymark\":\"" + companyInfo.getCompanymark()
							+ "\"";
				}
				if (companyInfo != null
						&& companyInfo.getRegisteredaddress() != null) {
					str += ",\"registeredaddress\":\""
							+ companyInfo.getRegisteredaddress() + "\"";
				}
				if (companyInfo != null
						&& companyInfo.getBusinessscope() != null) {
					str += ",\"businessscope\":\""
							+ companyInfo.getBusinessscope() + "\"";
				}
				if (companyInfo != null && companyInfo.getYl1() != null) {
					str += ",\"yl1\":\"" + companyInfo.getYl1() + "\"";
				}
				str += "}";
			} else {
				// 表示查询部门信息
				depart = this.departmentService
						.searchDepartByPrimaryKey(Integer.valueOf(queryData[0]));
				str = "{";
				if (depart != null && depart.getDeptId() != null) {
					str += "\"id\":\"" + depart.getDeptId() + "\"";
				}
				if (depart != null && depart.getDeptMak() != null) {
					str += ",\"deptMak\":\"" + depart.getDeptMak() + "\"";
				}
				if (depart != null && depart.getPdeptId() != null) {
					str += ",\"pdeptId\":\"" + depart.getPdeptId() + "\"";
				}
				if (depart != null && depart.getDeptName() != null) {
					str += ",\"deptName\":\"" + depart.getDeptName() + "\"";
				}
				if (depart != null && depart.getDingtalkId() != null) {
					str += ",\"dingtalkId\":\"" + depart.getDingtalkId() + "\"";
				}
				if (depart != null && depart.getDeptDirector() != null) {
					str += ",\"deptDirector\":\"" + depart.getDeptDirector()
							+ "\"";
				}
				// 所属公司
				if (depart != null && depart.getYl1() != null) {
					companyInfo = this.companyInfoService
							.selectByPrimaryKey(Integer
									.valueOf(depart.getYl1()));
					str += ",\"companyname\":\"" + companyInfo.getCompanyname()
							+ "\"";
					str += ",\"companyid\":\"" + companyInfo.getCompanyid()
							+ "\"";
				}
				// 查询部门负责人
				if (depart != null && depart.getDeptDirector() != null) {
					User user = userService.getUserById(depart
							.getDeptDirector());
					str += ",\"person_name\":\"" + user.getUsername() + "\"";
					str += ",\"personId\":\"" + user.getId() + "\"";
				}
				if (depart != null && depart.getYl2() != null) {
					str += ",\"yl2\":\"" + depart.getYl2() + "\"";
				}
				str += "}";
			}
		}
		try {
			UtilCommon.reponse(request, response, str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/easyUiTreeData")
	@ResponseBody
	public void easyUiTreeData(HttpServletRequest request,
			HttpServletResponse response, String id, String name) {
		// type=0 表示是公司，type=1表示是部门
		String str = "[{\"id\":\"" + 0 + ",-1\",\"text\":" + "\"组织架构\"";
		Depart temp_detp = new Depart();
		List<CompanyInfo> companys = companyInfoService
				.selectCompanyByPropterty(new CompanyInfo());
		if (companys != null && companys.size() > 0) {
			str += ",\"children\":[";
			for (CompanyInfo cp : companys) {
				str += "{\"id\":\"" + cp.getCompanyid() + ",0\",\"text\":\""
						+ cp.getCompanyname() + "\",";
				// 查询本公司下面的部门
				temp_detp.setYl1(String.valueOf(cp.getCompanyid()));
				departs = departmentService.searchDepartByProperty(temp_detp);
				if (departs != null && departs.size() > 0) {
					str += "\"children\":[";
					for (Depart detp : departs) {
						str += "{\"id\":\"" + detp.getDeptId()
								+ ",1\",\"text\":\"" + detp.getDeptName()
								+ "\",\"parentID\":\"" + cp.getCompanyid()
								+ "\",\"parentName\":\"" + cp.getCompanyname()
								+ "\"},";
					}
					str = str.subSequence(0, str.lastIndexOf(",")) + "]},";
				} else {
					str = str.subSequence(0, str.lastIndexOf(",")) + "},";
				}

			}
		}
		try {
			str = str.subSequence(0, str.lastIndexOf(",")) + "]}]";
			UtilCommon.reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DepartService getDepartmentService() {
		return departmentService;
	}

	@Autowired
	public void setDepartmentService(DepartService departmentService) {
		this.departmentService = departmentService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	@Autowired
	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

}
