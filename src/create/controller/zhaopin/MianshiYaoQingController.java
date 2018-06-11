package create.controller.zhaopin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import system.convert.ConvertWordToHtml;
import system.util.UtilCommon;
import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.hrm.User;
import create.model.system.SysRole;
import create.model.waipai.InterviewInvitation;
import create.model.waipai.JianLi;
import create.service.crm.CustomerInfoService;
import create.service.waipai.InterviewInvitationService;
import create.service.waipai.InterviewRecordService;
import create.service.waipai.JianliService;

@Controller
@RequestMapping("/mianshiYaoQingController")
public class MianshiYaoQingController extends BaseController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	private JianliService jianliService;
	
	private InterviewRecordService interviewRecordService;

	private InterviewInvitationService interviewInvitationService;

	private CustomerInfoService customerInfoService;

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Autowired
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	private JianLi jl;

	@RequestMapping("/toPageDateList")
	public String toPageDateList(HttpServletRequest request, String pId,
			String start, String end, String msstart, String msend,String jishuLx)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		
		//判断权限获取角色权限
		HttpSession sessionMap = request.getSession(true);
		List<SysRole> currentRoles = (List<SysRole>) sessionMap.getAttribute("currentRoles");
		Map authMap = (Map) sessionMap.getAttribute("role_authority");
		//获取所有的有效用户
		@SuppressWarnings("unused")
		List<User> allUsers = (List<User>) sessionMap.getAttribute("allUsers");
		User user = (User)sessionMap.getAttribute("user");
		if(UtilCommon.checkAuthority("hr_query_all",currentRoles,authMap)){
			params.put("id", null);
		}
		else if(UtilCommon.checkAuthority("hr_query_dept",currentRoles,authMap)){
			//得到部門下的員工id
			params.put("id", UtilCommon.getDepartUserIDs(user,allUsers));
		}else if(UtilCommon.checkAuthority("hr_query_personal",currentRoles,authMap)){
			params.put("id", sessionMap.getAttribute("userID").toString());
		}else{
//			yl3沒有分配任何權限,只有菜單權限
			params.put("departid", -1);
		}
		
		String pageNow = request.getParameter("pageNow");
		List<JianLi> jianliS = null;

		// 设置查询条件日期，昨天和今天
		// 昨天
		Date ztdate = new Date(new Date().getTime() - 24 * 60 * 60 * 1000);
		// 今天
		Date dt = new Date();
		Date mtdate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 默认查询昨天的邀请和今天的邀请
		if (start == null || "".equals(start)) {
			start = sdf.format(ztdate).toString();
		}
		if (end == null || "".equals(start)) {
			end = sdf.format(dt).toString();
		}
		// 默认显示今天和明天的面试简历

		if (msstart == null || "".equals(msstart)) {
			msstart = sdf.format(dt).toString();
		}
		if (msend == null || "".equals(msend)) {
			msend = sdf.format(mtdate).toString();
		}

		params.put("start", start);
		params.put("end", end);
		params.put("msstart", msstart);
		params.put("msend", msend);
		params.put("jishuLx", jishuLx);

		// 获取总条数
		Long totalCount = this.jianliService.pageCountsBySqlParamMap(params);
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

		jianliS = jianliService.pageDataBySqlParamMap(params);
		for (JianLi jl : jianliS) {
			if (jl.getJianliName() != null
					&& jl.getJianliName().split("&") != null) {
				jl.setName(jl.getJianliName().split("&")[0]);
				jl.setEmail(jl.getJianliName().split("&")[1]);
			}
		}
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("msstart", msstart);
		request.setAttribute("msend", msend);
		request.setAttribute("jianliS", jianliS);
		request.setAttribute("page", page);
		return "mywork/mianshiyaoqing/mianshiyaoqingList";
	}

	// 增加沟通记录
	@RequestMapping("/toAddInterviewInvitation")
	public ModelAndView toAddInterviewInvitation(HttpServletRequest request,
			String pId, InterviewInvitation record, String interviewdateStr,
			String invitationdateStr) throws Exception {
		// 面试邀请日期
		Date interviewdate = UtilCommon.StringToDate(interviewdateStr,
				"yyyy-MM-dd");
		Date invitationdate = UtilCommon.StringToDate(invitationdateStr,
				"yyyy-MM-dd hh:mm:ss");
		record.setInterviewdate(interviewdate);
		record.setInvitationdate(invitationdate);
		record.setJlPid(Integer.valueOf(pId));
		//添加邀请人
		User user = (User) request.getSession().getAttribute("user");
		record.setYl3(String.valueOf(user.getId()));
		interviewInvitationService.insertSelective(record);

		// 查询面试邀请详细
		try {
			Map<String, Object> params1 = new HashMap<String, Object>();
			List<InterviewInvitation> InterviewInvitations = null;
			// 查询条件
			// 设置分页页面信息
			params1.put("startIndex", 0);
			params1.put("endIndex", 100);
			// 如排序
			// 没有进行排序,默认排序方式
			params1.put("orderName", "age");
			params1.put("descAsc", "asc");
			params1.put("jlPid", Integer.valueOf(pId));
			InterviewInvitations = interviewInvitationService
					.pageListByParamMap(params1);
			request.setAttribute("InterviewInvitations", InterviewInvitations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(
				"redirect:/mianshiYaoQingController/toAddYaoQing.go?pId=" + pId);
	}

	@RequestMapping("/toMianshiyaodetailList")
	public String toMianshiyaodetailList(HttpServletRequest request, String pId)
			throws Exception {
		// 查询面试邀请详细
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			String pageNow = request.getParameter("pageNow");
			List<InterviewInvitation> InterviewInvitations = null;
			// 查询条件
			params.put("jlPid", Integer.valueOf(pId));
			// 获取总条数
			Long totalCount = this.interviewInvitationService
					.pageCounts(params);
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
			InterviewInvitations = interviewInvitationService
					.pageListByParamMap(params);
			request.setAttribute("InterviewInvitations", InterviewInvitations);
			request.setAttribute("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mywork/mianshiyaoqing/mianshiyaodetailList";
	}

	// 跳转到面试过程跟踪详细页面
	// ingerID面试邀请的id
	@RequestMapping("/toMianshiprocessDetail")
	public String toMianshiprocessDetail(HttpServletRequest request,
			String jlID, String customerId,String InterviewInvitation_id) throws Exception {
		// 查询面试邀请详细
		try {
			Date mtdate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			String ruzhishijian = sdf.format(mtdate).toString();
			//初始化时间
			request.setAttribute("ruzhishijian", ruzhishijian);
			if (customerId != null && !"".equals(customerId)) {
				request.setAttribute("customerInfo", customerInfoService
						.selectByPrimaryKey(Integer.valueOf(customerId)));
			}
			request.setAttribute("InterviewInvitation_id", InterviewInvitation_id);
			request.setAttribute("jlID", jlID);
			JianLi jl = jianliService.selectByPrimaryKey(Integer.valueOf(jlID));
			jl.setEmail(jl.getJianliName().split("&")[1]);
			request.setAttribute("jianli",jl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mywork/mianshiyaoqing/mianshiprocessDetail";
	}
	
	
	// pId 简历id 简历库页面的电话邀请按钮处理方法
	@RequestMapping("/seeJianli")
	public String seeJianli(HttpServletRequest request, String pId)
			throws Exception {
		Random random = new Random();
		if (pId != null && !"".equals(pId)&& !"null".equals(pId)) {
			jl = jianliService.selectByPrimaryKey(Integer.valueOf(pId));
			String randomHtmlJL_name = System.currentTimeMillis()
			+ String.valueOf(random.nextInt(10000)) + ".html";
			String ctxPath = jl.getJianliPath();
			// word文件地址
			String wordJianliPath = ctxPath + "\\" + jl.getJianliName();
			String htmlJianliPan = request.getSession().getServletContext()
					.getRealPath("/")
					+ '\\' + "jianli_html" + '\\' + randomHtmlJL_name;
//			poi word转换成html
			String inPath = ctxPath + '/';
			String inFileName = jl.getJianliName();
			String outPath = request.getSession().getServletContext()
			.getRealPath("/") + '\\' + "jianli_html" + '\\';
			String outFileName = randomHtmlJL_name;
			ConvertWordToHtml.cwth(inPath,inFileName,outPath,outFileName);
//			jacob把word转换成html
//			JacobUtil.wordToHtml(wordJianliPath, htmlJianliPan);
			request.setAttribute("randomHtmlJL_name", randomHtmlJL_name);
			request.setAttribute("jl", jl);
		}
		return "mywork/Jilihtml";
	}
	
	

	// pId 简历id 简历库页面的电话邀请按钮处理方法
	@RequestMapping("/toAddYaoQing")
	public String toAddYaoQing(HttpServletRequest request, String pId)
			throws Exception {
		Random random = new Random();
		if (pId != null && !"".equals(pId)) {
			jl = jianliService.selectByPrimaryKey(Integer.valueOf(pId));
		}
		String randomHtmlJL_name = System.currentTimeMillis()
				+ String.valueOf(random.nextInt(10000)) + ".html";
		if(jl!=null&&jl.getJianliName()!=null){
			request.setAttribute("interViewerName",
					jl.getJianliName().split("&")[0]);
			request.setAttribute("email", jl.getJianliName().split("&")[1]);
			request.setAttribute("mobile", jl.getJianliName().split("&")[2]);
			request.setAttribute("qq", jl.getJianliName().split("&")[3]);
			request.setAttribute("jl", jl);
			String ctxPath = jl.getJianliPath();
			// word文件地址
			String wordJianliPath = ctxPath + '\\' + jl.getJianliName();
			String htmlJianliPan = request.getSession().getServletContext()
			.getRealPath("/")
			+ '\\' + "jianli_html" + '\\' + randomHtmlJL_name;
			
			
//			poi word转换成html
			String inPath = ctxPath + '\\';
			String inFileName = jl.getJianliName();
			String outPath = request.getSession().getServletContext()
			.getRealPath("/") + '\\' + "jianli_html" + '\\';
			String outFileName = randomHtmlJL_name;
			ConvertWordToHtml.cwth(inPath,inFileName,outPath,outFileName);
			
//			// wordJianliPath word简历地址
//			// htmlJianliPan 转换成html的简历的地址
//			JacobUtil.wordToHtml(wordJianliPath, htmlJianliPan);
			request.setAttribute("randomHtmlJL_name", randomHtmlJL_name);
			request.setAttribute("jl", jl);
			// 查询面试邀请详细 结束
			Map param = new HashMap();
			param.put("customerproperty", 2);
			request.setAttribute("customerInfos", customerInfoService
					.queryListByParamMap(param));
		}
		
		// 查询面试邀请详细
		try {
			Map<String, Object> params1 = new HashMap<String, Object>();
			List<InterviewInvitation> InterviewInvitations = null;
			// 查询条件
			// 设置分页页面信息
			params1.put("startIndex", 0);
			params1.put("endIndex", 100);
			// 如排序
			// 没有进行排序,默认排序方式
			params1.put("orderName", "age");
			params1.put("descAsc", "asc");
			params1.put("jlPid", Integer.valueOf(pId));
			InterviewInvitations = interviewInvitationService
					.pageListByParamMap(params1);
			request.setAttribute("InterviewInvitations", InterviewInvitations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mywork/mianshiyaoqing/xinzengyaoqing";
	}


	public JianliService getJianliService() {
		return jianliService;
	}

	@Autowired
	public void setJianliService(JianliService jianliService) {
		this.jianliService = jianliService;
	}

	public InterviewInvitationService getInterviewInvitationService() {
		return interviewInvitationService;
	}

	@Autowired
	public void setInterviewInvitationService(
			InterviewInvitationService interviewInvitationService) {
		this.interviewInvitationService = interviewInvitationService;
	}
	
	public InterviewRecordService getInterviewRecordService() {
		return interviewRecordService;
	}

	@Autowired
	public void setInterviewRecordService(
			InterviewRecordService interviewRecordService) {
		this.interviewRecordService = interviewRecordService;
	}
}
