package create.controller.hrm;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import system.util.Md5;
import system.util.UtilCommon;
import system.util.http.HttpUtils;
import test.ReadPropertity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.crm.Zcproject;
import create.model.hrm.Depart;
import create.model.hrm.User;
import create.model.system.CompanyInfo;
import create.model.system.Right;
import create.model.system.SysRole;
import create.model.system.UserGroupRelation;
import create.service.crm.CustomerInfoService;
import create.service.crm.ZcprojectService;
import create.service.hrm.CompanyInfoService;
import create.service.hrm.DepartService;
import create.service.hrm.UserService;
import create.service.system.SysRightService;
import create.service.system.SysRoleService;
import create.service.system.UserGroupRelationService;
import test.dingTalk.DingTalkService;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	List users = null;
	Md5 md5 = new Md5();
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private ZcprojectService zcprojectService;
	private DepartService departmentService;
	
	String accessTokenUrl;
    String corpid;
    String secret;
    String access_token;


	private DepartService departService;
	
	private CustomerInfoService customerInfoService;

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Autowired
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}
	
	private SysRightService sysRightService;
	
	public SysRightService getSysRightService() {
		return sysRightService;
	}

	@Autowired
	public void setSysRightService(SysRightService sysRightService) {
		this.sysRightService = sysRightService;
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

	private SysRoleService sysRoleService;

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	@Autowired
	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	private CompanyInfoService companyInfoService;

	public DepartService getDepartService() {
		return departService;
	}

	@Autowired
	public void setDepartService(DepartService departService) {
		this.departService = departService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	@Autowired
	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * ������Ա
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/importData")
	public String importData(
			@RequestParam(value = "file", required = false)
			MultipartFile file) {
		Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            fs = new POIFSFileSystem(file.getInputStream());
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        User usr = null;
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
        for (int i = 1; i <= rowNum; i++) {
            	row = sheet.getRow(i);
            	int j = 0;
            	usr = new User();
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 0))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 0)).trim())){
            		 usr.setUsername(UtilCommon.getCellFormatValue(row.getCell((short) 0)).trim());
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 1))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 1)).trim())){
            		 usr.setDepartName(UtilCommon.getCellFormatValue(row.getCell((short) 1)).trim());
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 2))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 2)).trim())){
	            	 CompanyInfo cp = new CompanyInfo();
	            	 cp.setCompanyname(UtilCommon.getCellFormatValue(row.getCell((short) 2)).trim());
	            	 List<CompanyInfo> cps = companyInfoService.selectCompanyByPropterty(cp);
	            	 if(cps!=null&&cps.size()>0){
	            		 int cpid = cps.get(0).getCompanyid();
	            		 usr.setCompanyId(String.valueOf(cpid));
	            	 }
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 3))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 3)).trim())){
            		 usr.setTelephone((UtilCommon.getCellFormatValue(row.getCell((short) 3)).trim()));
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 4))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 4)).trim())){
            		 usr.setEmail(UtilCommon.getCellFormatValue(row.getCell((short) 4)).trim());
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 5))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 5)).trim())){
            		 if("��".equals(UtilCommon.getCellFormatValue(row.getCell((short) 5)).trim())){
            			 usr.setSex(1);
            		 }
            		 if("Ů".equals(UtilCommon.getCellFormatValue(row.getCell((short) 5)).trim())){
            			 usr.setSex(0);
            		 }
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 6))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 6)).trim())){
            		 usr.setJobName(UtilCommon.getCellFormatValue(row.getCell((short) 6)).trim());
            	 }
            	 if(UtilCommon.getCellFormatValue(row.getCell((short) 7))!=null&&!"".equals(UtilCommon.getCellFormatValue(row.getCell((short) 7)).trim())){
            		 usr.setIdno(UtilCommon.getCellFormatValue(row.getCell((short) 7)).trim());
            	 }
            	 usr.setStatus(0);
            	 userService.insertUser(usr);
            }
		return "system/RoleUpUsersList";
	}
	
	/*
	 * ��ѯ��ɫ�µ���Ա
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRoleUpUser")
	public String queryRoleUpUser(@RequestParam("dateid")
			String dateid,HttpServletRequest request) {
		if(dateid!=null&&!"".equals(dateid)){
			SysRole role = sysRoleService.selectByPK(Integer.valueOf(dateid));
			request.setAttribute("role", role);
		}
		Map hashMap = new HashMap();
		if (dateid != null && !"".equals(dateid)) {
			hashMap.put("tgId", dateid);
		}
		List<UserGroupRelation> user_relations = userGroupRelationService
				.selectByUserGroupRelationByParamMap(hashMap);
		List<User> userList = new ArrayList();
		for(UserGroupRelation ur:user_relations){
			User u = userService.getUserById(ur.getTuId());
			userList.add(u);
		}
		request.setAttribute("userList", userList);
		request.setAttribute("roleId", dateid);
		return "system/RoleUpUsersList";
	}

	@RequestMapping("/adduser")
	public ModelAndView adduser(User us, @RequestParam("resume")
	MultipartFile file, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			us.setPassword(md5.GetMD5Code(us.getPassword()));
			userService.insertUser(us);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/userController/showUsers.go");
	}

	@RequestMapping("/save_user")
	public ModelAndView saveUser(User us, HttpServletRequest request) {
		try {
			//�ⲿ��Ա��Ҫ��дפ���ͻ�����Ϣ
			if(us.getInternalstaff()==0){
				us.setInternalstaff(us.getCustomerId());
			}
			//�����ˣ�����ʱ��
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date d =new Date(); String dd =format.format(d);
			us.setCreatetime(format.parse(dd));
			HttpSession sessionMap = request.getSession(true);
			User new_user = (User)sessionMap.getAttribute("user");
			us.setCreateby(new_user.getId());
			userService.insertUser(us);
			
//			����������Ա��Ϣ
//			�����ػ���
//			�޸�����Ժ�ͬ�������޸Ķ����в�����Ϣ
			JSONObject resutJSON = null;
			if("3".equals(us.getCompanyId())){
				corpid = ReadPropertity.getProperty("create_hd_corpid");
		        secret = ReadPropertity.getProperty("create_hd_secret");
			}
//			��������Ϣ����
			if("1".equals(us.getCompanyId())){
				corpid = ReadPropertity.getProperty("create_corpid");
		        secret = ReadPropertity.getProperty("create_secret");
			}
			accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
	        access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
	        HttpUtils httpUtils = new HttpUtils();
	        //�ж϶����û�ID�Ƿ�Ϊ�գ���Ϊ�����������ݵ�����������Ϊ�����޸�
	        String result;//���ö����ӿڷ�������
	       if(!"".equals(corpid)&&!"".equals(secret)){
	    	    JSONObject jsonobject_post = new JSONObject();
//		        ����
	    	    List depart_list = new ArrayList();
	    	    if(us.getDepartid()!=null&&!"".equals(us.getDepartid()!=null)){
	    	    	Depart dp =departmentService.searchDepartByPrimaryKey(us.getDepartid());
	        	    depart_list.add(dp.getDingtalkId());
	    	    }
	    	    jsonobject_post.put("department", depart_list);
		        jsonobject_post.put("name", us.getUsername());
		        jsonobject_post.put("tel", us.getTelephone());//�����绰
		        jsonobject_post.put("mobile", us.getMobile0());//�ֻ���
		        jsonobject_post.put("email", us.getEmail());
		        jsonobject_post.put("position", us.getJobName());
		        jsonobject_post.put("userid", us.getId());
		        //����
		        jsonobject_post.put("jobnumber", us.getId());
		        result = httpUtils.doPost("https://oapi.dingtalk.com/user/create?access_token="+access_token, jsonobject_post, "UTF-8");
	    	    resutJSON = JSONObject.parseObject(result);
				resutJSON = JSON.parseObject(result);
				int msg = 1;
				if(resutJSON.get("errcode")!=null){
					 msg = Integer.valueOf((resutJSON.get("errcode").toString()));
				}
				String errmsg = (String)resutJSON.get("errmsg");
				System.out.println(errmsg);
		        if(msg==0){
		            System.out.println("�Ѿ�ͬ������");
		            //ͬ���ɹ���userid���ó�dingtalkID
		            us.setDingtalkId(us.getId().toString());
		            userService.upDateUser(us);
		        }
	       }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/userController/showUsers.go");
	}

	@RequestMapping("/to_edite")
	public String toEdite(HttpServletRequest request) {
		// ��ѯ����������ϸ ����
		Map param = new HashMap();
		param.put("customerproperty", 2);
		request.setAttribute("customerInfos", customerInfoService
				.queryListByParamMap(param));
		try {
			User user = null;
			String roleNames = "";
			String id = request.getParameter("id");

			UserGroupRelation userGroupRelation = new UserGroupRelation();
			List<Integer> roleids = null;
			if (id != null) {
				roleids = userGroupRelationService
						.findUserGroupRelation(Integer.valueOf(id));
				for (Integer roleId : roleids) {
					SysRole sr = sysRoleService.selectByPK(roleId);
					if (sr != null) {
						roleNames += sr.getRoleName() + "  ";
					}
				}
			}
			String dotype = request.getParameter("dotype");
			request.setAttribute("dotype", dotype);
			if (!"".equals(dotype) && "0".equals(dotype)) {
				user = userService.getUserById(Integer.valueOf(id));
				// ���user�еĽ�ɫ��Ϣ
				user.setRoleName(roleNames);
				request.setAttribute("editeUser", user);
			}
//			��ѯ��Ա�����ͻ��������Ŀ
			Map para = new HashMap();
			if(user.getInternalstaff()!=null&&user.getInternalstaff()!=1){//internalstaff=1��ʾ�ڲ�Ա��
				para.put("cid", user.getInternalstaff());
				List<Zcproject> zcprojects = zcprojectService.selectZcprojectByParamMap(para);
				request.setAttribute("zcprojects", zcprojects);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/user_edite_or_add";
	}

	@RequestMapping("/edite_user")
	public ModelAndView editeUser(HttpServletRequest request, User user) {
//		�޸Ķ�����Ա��Ϣ
//		�����ػ���
//		�޸�����Ժ�ͬ�������޸Ķ����в�����Ϣ
		JSONObject resutJSON = null;
		if("3".equals(user.getCompanyId())){
			corpid = ReadPropertity.getProperty("create_hd_corpid");
	        secret = ReadPropertity.getProperty("create_hd_secret");
		}
//		��������Ϣ����
		if("1".equals(user.getCompanyId())){
			corpid = ReadPropertity.getProperty("create_corpid");
	        secret = ReadPropertity.getProperty("create_secret");
		}
		accessTokenUrl = ReadPropertity.getProperty("accessTokenUrl");
        access_token = DingTalkService.getAccessToken(accessTokenUrl,corpid,secret);
        HttpUtils httpUtils = new HttpUtils();
        //�ж϶����û�ID�Ƿ�Ϊ�գ���Ϊ�����������ݵ�����������Ϊ�����޸�
        String result;//���ö����ӿڷ�������
       if(!"".equals(corpid)&&!"".equals(secret)){
    	    JSONObject jsonobject_post = new JSONObject();
//	        ����
    	    List depart_list = new ArrayList();
    	    if(user.getDepartid()!=null){
    	    	Depart dp =departmentService.searchDepartByPrimaryKey(user.getDepartid());
    	    	if(dp!=null){
    	    	    depart_list.add(dp.getDingtalkId());
    	    	}
    	    }
    	    jsonobject_post.put("department", depart_list);
	        jsonobject_post.put("name", user.getUsername());
	        jsonobject_post.put("tel", user.getTelephone());//�����绰
	        jsonobject_post.put("mobile", user.getMobile0());//�ֻ���
	        jsonobject_post.put("email", user.getEmail());
	        jsonobject_post.put("position", user.getJobName());
	        //����
	        jsonobject_post.put("jobnumber", user.getId());
    	    if(user.getDingtalkId()!=null&&!"".equals(user.getDingtalkId())){
    	    	jsonobject_post.put("userid", user.getDingtalkId());
    	    	result = httpUtils.doPost("https://oapi.dingtalk.com/user/update?access_token="+access_token, jsonobject_post, "UTF-8");
    	    	
    	    }else{
    	    	 jsonobject_post.put("userid", user.getId());
    	    	 result = httpUtils.doPost("https://oapi.dingtalk.com/user/create?access_token="+access_token, jsonobject_post, "UTF-8");
    	    }
    	    resutJSON = JSONObject.parseObject(result);
			resutJSON = JSON.parseObject(result);
			int msg = 1;
			if(resutJSON.get("errcode")!=null){
				 msg = Integer.valueOf((resutJSON.get("errcode").toString()));
			}
			String errmsg = (String)resutJSON.get("errmsg");
	        if(msg==0){
	            System.out.println("�Ѿ�ͬ������");
	        }
       }
	
		String dotype = request.getParameter("dotype");
		//�����ˣ�����ʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d =new Date(); 
		String dd =format.format(d);
		try {
			user.setModifytime(format.parse(dd));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession sessionMap = request.getSession(true);
		User new_user = (User)sessionMap.getAttribute("user");
		user.setCreateby(new_user.getId());
		//�ⲿ��Ա��Ҫ��дפ���ͻ�����Ϣ
		if(user!=null&&user.getInternalstaff()!=null&&user.getInternalstaff()==0){
			user.setInternalstaff(user.getCustomerId());
		}
		//dotype����2ɾ��
		if (!"".equals(dotype) && "2".equals(dotype)) {
			String ids = request.getParameter("ids");
			String idArr[] = ids.split(",");
			if (!"".equals(idArr) && idArr.length > 0) {
				for (String id : idArr) {
					if (!"".equals(id)) {
						user.setStatus(2);
						user.setId(Integer.valueOf(id.trim()));
						userService.upDateUser(user);
//						ɾ��������Ա��Ϣ
				         httpUtils = new HttpUtils();
				        //�ж϶����û�ID�Ƿ�Ϊ�գ���Ϊ�����������ݵ�����������Ϊ�����޸�
				       if(!"".equals(corpid)&&!"".equals(secret)){
					        result = httpUtils.doGet("https://oapi.dingtalk.com/user/delete?access_token="+access_token+"&userid="+userService.selectByPrimaryKey(user.getId()).getDingtalkId());
				    	    resutJSON = JSONObject.parseObject(result);
							resutJSON = JSON.parseObject(result);
							int msg = 1;
							if(resutJSON.get("errcode")!=null){
								 msg = Integer.valueOf((resutJSON.get("errcode").toString()));
							}
							String errmsg = (String)resutJSON.get("errmsg");
							System.out.println(errmsg);
					        if(msg==0){
					            System.out.println("�Ѿ�ͬ������");
					        }
				       }
					}
				}
			}
		} else {
			if(user.getPassword()!=null){
				user.setPassword(md5.GetMD5Code(user.getPassword()));
			}
			if(user.getZcPid()!=null&&!"".equals(user.getZcPid())){
				user.setZcprojectId(Integer.valueOf(user.getZcPid()));
			}
			if(user.getDingtalkId()!=null&&!"".equals(user.getDingtalkId())){
				if(resutJSON.get("userid")!=null){
					user.setDingtalkId((String)resutJSON.get("userid"));
				}
			}
			userService.upDateUser(user);
		}
		return new ModelAndView("redirect:/userController/showUsers.go");
	}
	
	
	

	@RequestMapping("/showUsers")
	public String showUserList(User us, Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			//�ж�Ȩ�޻�ȡ��ɫȨ��
			HttpSession sessionMap = request.getSession(true);
			List<SysRole> currentRoles = (List<SysRole>) sessionMap.getAttribute("currentRoles");
			Map authMap = (Map) sessionMap.getAttribute("role_authority");
			//��ȡ���е���Ч�û�
			@SuppressWarnings("unused")
			List<User> allUsers = (List<User>) sessionMap.getAttribute("allUsers");
			User user = (User)sessionMap.getAttribute("user");
			if(UtilCommon.checkAuthority("hr_query_all",currentRoles,authMap)){
				params.put("yl3", null);
			}
			else if(UtilCommon.checkAuthority("hr_query_dept",currentRoles,authMap)){
				//�õ����T�µĆT��id
				params.put("yl3", UtilCommon.getDepartUserIDs(user,allUsers));
			}else if(UtilCommon.checkAuthority("hr_query_personal",currentRoles,authMap)){
				params.put("yl3", sessionMap.getAttribute("userID").toString());
			}else{
//				yl3�]�з����κΙ���,ֻ�вˆΙ���
				params.put("yl3", -1);
			}
			if(us.getUsername()!=null&&!"".equals(us.getUsername())){
				params.put("username",us.getUsername());
			}
			if(us.getDepartName()!=null&&!"".equals(us.getDepartName())){
				params.put("departName",us.getDepartName());
			}
			if(us.getSex()!=null&&!"".equals(us.getSex())){
				params.put("sex",us.getSex());
			}
			if(us.getInternalstaff()!=null&&!"".equals(us.getInternalstaff())){
				params.put("internalstaff",us.getInternalstaff());
			}
			String pageNow = request.getParameter("pageNow");
			// ��ȡ������
			Long totalCount = this.userService.pageCounts(params);
			// ���÷�ҳ����
			Page page = executePage(request, totalCount);
			if(totalCount>(page.getEveryPage()*page.getCurrentPage())){
				page.setHasNextPage(true);
			}else{
				page.setHasNextPage(false);
			}
			// ���÷�ҳҳ����Ϣ
			params.put("startIndex", page.getBeginIndex());
			params.put("endIndex", page.getEveryPage());
			// ������
			if (page.isSort()) {
				params.put("orderName", page.getSortName());
				params.put("descAsc", page.getSortState());
			} else {
				// û�н�������,Ĭ������ʽ
				params.put("orderName", "age");
				params.put("descAsc", "asc");
			}
			// 0��ʾ��ְԱ����1�Ѿ���ְԱ����2���Ѿ���ɾ��Ա��
			request.setAttribute("type", request.getParameter("type"));
			request.setAttribute("page", page);
			params.put("status", 0);
			users = userService.pageListByParamMap(params);
			model.put("users", users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Ա����������
		if (type == null || !"1".equals(type)) {
			return "hrm/user_list";
		} else {
			return "hrm/jianli_user_list";
		}
	}

	@RequestMapping("/select_userData")
	public String selectuserData(User us, Map<String, Object> model,
			HttpServletRequest request) {
		try {
			request.setAttribute("departData", departService
					.searchDepartByProperty(null));
			request.setAttribute("companyData", companyInfoService
					.selectCompanyByPropterty(null));
			Map<String, Object> params = new HashMap<String, Object>();
			String pageNow = request.getParameter("pageNow");
			//���ò�ѯ����
			if(request.getParameter("departid")!=null&&!"".equals(request.getParameter("departid"))){
				params.put("departid", request.getParameter("departid"));
			}
			if(request.getParameter("companyId")!=null&&!"".equals(request.getParameter("companyId"))){
				params.put("companyId", request.getParameter("companyId"));
			}
			if(request.getParameter("username")!=null&&!"".equals(request.getParameter("username"))){
				params.put("username", request.getParameter("username"));
			}
			if(request.getParameter("sex")!=null&&!"".equals(request.getParameter("sex"))){
				params.put("sex", request.getParameter("sex"));
			}
			// ��ȡ������
			Long totalCount = this.userService.pageCounts(params);
			// ���÷�ҳ����
			Page page = executePage(request, totalCount);
			// ���÷�ҳҳ����Ϣ
			params.put("startIndex", page.getBeginIndex());
			params.put("endIndex", page.getEveryPage());
			// ������
			if (page.isSort()) {
				params.put("orderName", page.getSortName());
				params.put("descAsc", page.getSortState());
			} else {
				// û�н�������,Ĭ������ʽ
				params.put("orderName", "age");
				params.put("descAsc", "asc");
			}
			// 0��ʾ��ְԱ����1�Ѿ���ְԱ����2���Ѿ���ɾ��Ա��
			request.setAttribute("type", request.getParameter("type"));
			request.setAttribute("page", page);
			params.put("status", 0);
			users = userService.pageListByParamMap(params);
			model.put("users", users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/select_user_data";
	}

	@RequestMapping("/login")
	public String login(User us, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model)
			throws IOException {
		Md5 md5 = new Md5();
		String view = "";
		view = "main";
		HttpSession sessionMap = request.getSession(true);

		ServletContext applicationMap = request.getSession()
				.getServletContext();
		// �����sessionId
		String currentSeesionId = request.getSession().getId();
		if (us.getPassword() != null) {
			us.setPassword(md5.GetMD5Code(us.getPassword()));
		}
		User loanUser = null;
		if (sessionMap.getAttribute("user") != null) {
			loanUser = (User) sessionMap.getAttribute("user");
		} else {
			if(us!=null&&us.getLoginid()!=null&&us.getPassword()!=null){
				Map param = new HashMap();
				param.put("password", us.getPassword());
				param.put("loginid", us.getLoginid());
				//��ʼ����ѯ����
				param.put("startIndex", 0);
				param.put("endIndex", 10);
				users = userService.pageListByParamMap(param);
				if (users != null && users.size() > 0) {
					loanUser = (User) users.get(0);
				}
			}
		}

		if (loanUser != null) {
			// Status!=1��ʾ��һ�ε�¼
			if (loanUser.getStatus() != 1) {
				loanUser.setStatus(1);// ���û��ĵ�¼״̬��Ϊ1����ʾ�û����ڻ�Ծ״̬
				if (applicationMap.getAttribute(loanUser.getLoginid()) == null) {
					if (applicationMap.getAttribute(loanUser.getLoginid()) == null) {
						applicationMap.setAttribute(loanUser.getLoginid(),
								currentSeesionId);
						applicationMap.setAttribute(currentSeesionId, loanUser
								.getLoginid());
						applicationMap.setAttribute("loginAdress", request
								.getRemoteAddr());
					}
				}
				sessionMap.setAttribute(sessionMap.getId(), loanUser
						.getLoginid());
				// ���û�������ɫ���뻺����
				List<SysRole> currentRoles = new ArrayList();
				UserGroupRelation userGroupRelation = new UserGroupRelation();
				List<Integer> roleids = null;
				roleids = userGroupRelationService
						.findUserGroupRelation(loanUser.getId());
				Map paraMap = new HashMap();
				Map authMap = new HashMap();
				for (Integer roleId : roleids) {
					SysRole sr = sysRoleService.selectByPK(roleId);
					currentRoles.add(sr);
					//��ѯ����ɫ��Ȩ�޷����ڴ���
					paraMap.put("right_type", "right_type");
					paraMap.put("tg_id", roleId);
					paraMap.put("detail", "detail");
					List<Right> rights = sysRightService.selectByProperyByParamMap(paraMap);
					authMap.put(String.valueOf(roleId), rights);
				}
				sessionMap.setAttribute("role_authority", authMap);
				// ���û��ĵ�¼��Ϣ����session��
				sessionMap.setAttribute("c_user", loanUser.getUsername());
				sessionMap.setAttribute("currentRoles", currentRoles);
				sessionMap.setAttribute("user", loanUser);
				sessionMap.setAttribute("userID", loanUser.getId());
				/*
				 * ����ϵͳ��Ч���û�
				 */
				Map param = new HashMap();
//				���÷�ҳ����
				
				sessionMap.setAttribute("allUsers", this.userService.pageListByParamMap(param));
				
			}
		} else {
			request.setAttribute("message", "�û��������������");
			view = "error";
		}
		return view;
	}

	// �Ƴ�ϵͳ
	@RequestMapping("/logout")
	public void logout(User us, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession sessionMap = request.getSession(true);
		sessionMap.removeAttribute("c_user");
		sessionMap.removeAttribute("currentRoles");
		sessionMap.removeAttribute("user");
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				// �ҵ���Ҫɾ����Cookie
				if (name.compareTo("target-key") == 0) {
					// ����������Ϊ0
					cookie.setMaxAge(0);
					// ���Response����Ч
					response.addCookie(cookie);
				}
			}
		}

		String returnadress = request.getRequestURL().toString().split(
				"userController")[0];
		response.sendRedirect(returnadress + "login_b/login.jsp");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> validate(
			@RequestParam(value = "name", required = true)
			String name, @RequestParam(value = "pass", required = true)
			String pass) {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		try {
			name = URLDecoder.decode(name, "UTF-8");
			pass = URLDecoder.decode(pass, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User us = new User();
		Map param = new HashMap();
		param.put("loginid", name);
		param.put("password", md5.GetMD5Code(pass));
		param.put("startIndex", 0);
		param.put("endIndex", 10);
		users = userService.pageListByParamMap(param);
		User u = null;
		if (users != null && users.size() > 0) {
			u = (User) users.get(0);
		}
		if (u == null) {
			modelMap.put("message", "�û������벻ƥ����ߴ���");
		} else {
			modelMap.put("message", "true");
		}
		return modelMap;
	}

	public ZcprojectService getZcprojectService() {
		return zcprojectService;
	}
    @Autowired
	public void setZcprojectService(ZcprojectService zcprojectService) {
		this.zcprojectService = zcprojectService;
	}

	public DepartService getDepartmentService() {
		return departmentService;
	}
	@Autowired
	public void setDepartmentService(DepartService departmentService) {
		this.departmentService = departmentService;
	}

}
