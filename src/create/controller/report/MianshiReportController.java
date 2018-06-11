/**
 * 
 */
package create.controller.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import system.util.UtilCommon;
import create.model.crm.ContactInfro;
import create.model.hrm.Depart;
import create.model.hrm.User;
import create.model.report.MianshiInterviewReportModel;
import create.model.system.CompanyInfo;
import create.service.hrm.UserService;
import create.service.waipai.InterviewInvitationService;

/**
 * @author guohaihang
 * 
 */
@Controller
@RequestMapping("/mianshiReportController")
public class MianshiReportController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private InterviewInvitationService interviewInvitationService;

	// 获取报表数据
	@RequestMapping(value = "/reportSeries")
	// @ResponseBody
	public String reportSeries(HttpServletRequest request,
			HttpServletResponse response, String id, String name) {
		String text = "2016年6月份招聘分析";
		String type = "pie";
		String series = "[{name: 'Brands',colorByPoint: true,data: [{name: 'java软件工程师', y: 56.33}, {name: 'php软件工程师',y: 24.03,sliced: true,"
				+ "selected: true}, {name: '安卓软件工程师',y: 10.38}, {name: '.Net软件工程师',y: 4.77}, {name: 'IOS软件工程师',y: 0.91}, {name: '运维工程师'"
				+ ",y: 0.2}]}]";
		request.setAttribute("text", text);
		request.setAttribute("type", type);
		request.setAttribute("series", series);
		return "/report/ImageReport/testreport";
	}

	@RequestMapping("/weekInterviewReport")
	public String weekinterviewReport(
			MianshiInterviewReportModel interviewReportModel,
			HttpServletRequest request, String customerid) {
		List<User> users = userService.pageListByParamMap(null);
		Date dt = new Date();
		// 获取当前日期的周一和周日
		String[] monday_sunday = UtilCommon.monday_sunday(dt);
		// 初始化面试查询时间
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_interviewDate_start() == null) {
			// 获取周一
			interviewReportModel.setQuery_interviewDate_start(monday_sunday[0]);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_interviewDate_end() == null) {
			// 获取周一
			interviewReportModel.setQuery_interviewDate_end(monday_sunday[1]);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_invitationDate_start() == null) {
			// 获取周日
			interviewReportModel
					.setQuery_invitationDate_start(monday_sunday[0]);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_invitationDate_end() == null) {
			// 获取周日
			interviewReportModel.setQuery_invitationDate_end(monday_sunday[1]);
		}
		// 查询条件
		Map param = new HashMap();
		if (interviewReportModel.getQuery_interviewDate_start() != null
				&& !"".equals(interviewReportModel
						.getQuery_interviewDate_start())) {
			param.put("query_interviewDate_start", interviewReportModel
					.getQuery_interviewDate_start());
		}
		if (interviewReportModel.getQuery_interviewDate_end() != null
				&& !""
						.equals(interviewReportModel
								.getQuery_interviewDate_end())) {
			param.put("query_interviewDate_end", interviewReportModel
					.getQuery_interviewDate_end());
		}
		if (interviewReportModel.getQuery_invitationDate_start() != null
				&& !"".equals(interviewReportModel
						.getQuery_invitationDate_start())) {
			param.put("query_invitationDate_start", interviewReportModel
					.getQuery_invitationDate_start());
		}
		if (interviewReportModel.getQuery_invitationDate_end() != null
				&& !"".equals(interviewReportModel
						.getQuery_invitationDate_end())) {
			param.put("query_invitationDate_end", interviewReportModel
					.getQuery_invitationDate_end());
		}
		param.put("userID", interviewReportModel.getUserID());
		List<MianshiInterviewReportModel> reportDate = interviewInvitationService
				.mianshiInterviewReport(param);
		for (MianshiInterviewReportModel model : reportDate) {
			model.setHxzName(model.getJianli_name().split("&")[0]);
			model.setEmail(model.getJianli_name().split("&")[1]);
			model.setMobel_phone(model.getJianli_name().split("&")[2]);
			model.setQq(model.getJianli_name().split("&")[3]);
		}
		request.setAttribute("interviewReportModel", interviewReportModel);
		request.setAttribute("users", users);
		request.setAttribute("reportDate", reportDate);
		return "report/weekInterviewReport";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/todayInterviewReport")
	public String todayinterviewReport(
			MianshiInterviewReportModel interviewReportModel,
			HttpServletRequest request, String customerid) {
		List<User> users = userService.pageListByParamMap(null);
		SimpleDateFormat smdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat smdf_hms = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dt = new Date();
		String today = smdf.format(dt);
		// 初始化面试查询时间
		String today_hms = smdf_hms.format(dt);
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_interviewDate_start() == null) {
			interviewReportModel.setQuery_interviewDate_start(today);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_interviewDate_end() == null) {
			interviewReportModel.setQuery_interviewDate_end(today);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_invitationDate_start() == null) {
			interviewReportModel.setQuery_invitationDate_start(today_hms);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_invitationDate_end() == null) {
			interviewReportModel.setQuery_invitationDate_end(today_hms);
		}
		// 查询条件
		Map param = new HashMap();
		if (interviewReportModel.getQuery_interviewDate_start() != null
				&& !"".equals(interviewReportModel
						.getQuery_interviewDate_start())) {
			param.put("query_interviewDate_start", interviewReportModel
					.getQuery_interviewDate_start());
		}
		if (interviewReportModel.getQuery_interviewDate_end() != null
				&& !""
						.equals(interviewReportModel
								.getQuery_interviewDate_end())) {
			param.put("query_interviewDate_end", interviewReportModel
					.getQuery_interviewDate_end());
		}
		if (interviewReportModel.getQuery_invitationDate_start() != null
				&& !"".equals(interviewReportModel
						.getQuery_invitationDate_start())) {
			param.put("query_invitationDate_start", interviewReportModel
					.getQuery_invitationDate_start());
		}
		if (interviewReportModel.getQuery_invitationDate_end() != null
				&& !"".equals(interviewReportModel
						.getQuery_invitationDate_end())) {
			param.put("query_invitationDate_end", interviewReportModel
					.getQuery_invitationDate_end());
		}
		param.put("userID", interviewReportModel.getUserID());
		List<MianshiInterviewReportModel> reportDate = interviewInvitationService
				.mianshiInterviewReport(param);
		for (MianshiInterviewReportModel model : reportDate) {
			model.setHxzName(model.getJianli_name().split("&")[0]);
			model.setEmail(model.getJianli_name().split("&")[1]);
			model.setMobel_phone(model.getJianli_name().split("&")[2]);
			model.setQq(model.getJianli_name().split("&")[3]);
		}
		request.setAttribute("interviewReportModel", interviewReportModel);
		request.setAttribute("users", users);
		request.setAttribute("reportDate", reportDate);
		return "report/todayInterviewReport";
	}

	@RequestMapping("/monthInterviewReport")
	public String contactInfoList(
			MianshiInterviewReportModel interviewReportModel,
			HttpServletRequest request, String customerid) {
		List<User> users = userService.pageListByParamMap(null);
		Date dt = new Date();
		// 获取当前日期的周一和周日
		String[] first_endOfMonth = UtilCommon.first_endDayOfMonth();
		// 初始化面试查询时间
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_interviewDate_start() == null) {
			// 获取周一
			interviewReportModel
					.setQuery_interviewDate_start(first_endOfMonth[0]);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_interviewDate_end() == null) {
			// 获取周一
			interviewReportModel
					.setQuery_interviewDate_end(first_endOfMonth[1]);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_invitationDate_start() == null) {
			// 获取周日
			interviewReportModel
					.setQuery_invitationDate_start(first_endOfMonth[0]);
		}
		if (interviewReportModel != null
				&& interviewReportModel.getQuery_invitationDate_end() == null) {
			// 获取周日
			interviewReportModel
					.setQuery_invitationDate_end(first_endOfMonth[1]);
		}
		// 查询条件
		Map param = new HashMap();
		if (interviewReportModel.getQuery_interviewDate_start() != null
				&& !"".equals(interviewReportModel
						.getQuery_interviewDate_start())) {
			param.put("query_interviewDate_start", interviewReportModel
					.getQuery_interviewDate_start());
		}
		if (interviewReportModel.getQuery_interviewDate_end() != null
				&& !""
						.equals(interviewReportModel
								.getQuery_interviewDate_end())) {
			param.put("query_interviewDate_end", interviewReportModel
					.getQuery_interviewDate_end());
		}
		if (interviewReportModel.getQuery_invitationDate_start() != null
				&& !"".equals(interviewReportModel
						.getQuery_invitationDate_start())) {
			param.put("query_invitationDate_start", interviewReportModel
					.getQuery_invitationDate_start());
		}
		if (interviewReportModel.getQuery_invitationDate_end() != null
				&& !"".equals(interviewReportModel
						.getQuery_invitationDate_end())) {
			param.put("query_invitationDate_end", interviewReportModel
					.getQuery_invitationDate_end());
		}
		param.put("userID", interviewReportModel.getUserID());
		List<MianshiInterviewReportModel> reportDate = interviewInvitationService
				.mianshiInterviewReport(param);
		for (MianshiInterviewReportModel model : reportDate) {
			model.setHxzName(model.getJianli_name().split("&")[0]);
			model.setEmail(model.getJianli_name().split("&")[1]);
			model.setMobel_phone(model.getJianli_name().split("&")[2]);
			model.setQq(model.getJianli_name().split("&")[3]);
		}
		request.setAttribute("interviewReportModel", interviewReportModel);
		request.setAttribute("users", users);
		request.setAttribute("reportDate", reportDate);
		return "report/monthInterviewReport";
	}

	public InterviewInvitationService getInterviewInvitationService() {
		return interviewInvitationService;
	}

	@Autowired
	public void setInterviewInvitationService(
			InterviewInvitationService interviewInvitationService) {
		this.interviewInvitationService = interviewInvitationService;
	}

}
