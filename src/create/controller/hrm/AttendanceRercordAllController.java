package create.controller.hrm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.util.UtilCommon;
import create.model.hrm.AttendanceRercordAll;
import create.model.hrm.User;
import create.service.hrm.AttendanceRercordAllService;
import create.service.hrm.UserService;

@Controller
@RequestMapping("/attendanceRercordAllController")
public class AttendanceRercordAllController {
	
private	AttendanceRercordAllService attendanceRercordAllService;

public AttendanceRercordAllService getAttendanceRercordAllService() {
	return attendanceRercordAllService;
}

@Autowired
public void setAttendanceRercordAllService(
		AttendanceRercordAllService attendanceRercordAllService) {
	this.attendanceRercordAllService = attendanceRercordAllService;
}

private UserService userService;

public UserService getUserService() {
	return userService;
}

@Autowired
public void setUserService(UserService userService) {
	this.userService = userService;
}


@RequestMapping("/showAttendanceRecordDetail")
public String showAttendanceRecordDetail(HttpServletRequest request, AttendanceRercordAll attendanceRercordAll) {
	UtilCommon utilCommon = new UtilCommon();
	String[] month_first_endDay = utilCommon.first_endDayOfMonth();
	request.setAttribute("month_first_endDay", month_first_endDay);
	Map paramMap = new HashMap();
	if(StringUtils.isEmpty(request.getParameter("workday_begin"))){
		paramMap.put("workday_begin", month_first_endDay[0]);
	}else{
		paramMap.put("workday_begin", request.getParameter("workday_begin"));
	}
	if(StringUtils.isEmpty(request.getParameter("workday_begin"))){
		paramMap.put("workday_end", month_first_endDay[1]);
	}else{
		paramMap.put("workday_end", request.getParameter("workday_end"));
	}
	paramMap.put("userid", request.getParameter("userid"));
	List<AttendanceRercordAll> AttendanceRercordAll_List = attendanceRercordAllService.queryAttendanceRecordAllByPropertys(paramMap);
	Map param = null;
	for(AttendanceRercordAll record:AttendanceRercordAll_List){
		if(record.getWorkdate()!=null&&record.getWorkdate().split(" ").length>0){
			String workDate = record.getWorkdate().split(" ")[0];
			String weekDate = UtilCommon.dateToWeek(workDate);
			record.setWorkdate(workDate+" "+weekDate);
		}
		record.getUserid();
		param = new HashMap();
		param.put("dingtalkId", record.getUserid());
		List<User> userList = userService.pageListByParamMap(param);
		if(userList!=null&&userList.size()>0){
			record.setUserName(userList.get(0).getUsername());
			record.setJobName(userList.get(0).getJobName());
			record.setDepartName(userList.get(0).getDepartName());
		}
	}
	request.setAttribute("AttendanceRercordAll_List", AttendanceRercordAll_List);
	return "hrm/attendanceRecordDetail";
}

/*
 * 按日统计查询考勤详细方法
 */
@RequestMapping("/attendanceRecordDetail")
public String attendanceRecordDetail(HttpServletRequest request, AttendanceRercordAll attendanceRercordAll) {
	UtilCommon utilCommon = new UtilCommon();
	Map paramMap = new HashMap();
	paramMap.put("workDate", request.getParameter("workDate"));
	paramMap.put("userid", request.getParameter("userid"));
	List<AttendanceRercordAll> AttendanceRercordAll_List = attendanceRercordAllService.queryAttendanceRecordAllByPropertys(paramMap);
	Map param = null;
	for(AttendanceRercordAll record:AttendanceRercordAll_List){
		if(record.getWorkdate()!=null&&record.getWorkdate().split(" ").length>0){
			String workDate = record.getWorkdate().split(" ")[0];
			String weekDate = UtilCommon.dateToWeek(workDate);
			record.setWorkdate(workDate+" "+weekDate);
		}
		record.getUserid();
		param = new HashMap();
		param.put("dingtalkId", record.getUserid());
		List<User> userList = userService.pageListByParamMap(param);
		if(userList!=null&&userList.size()>0){
			record.setUserName(userList.get(0).getUsername());
			record.setJobName(userList.get(0).getJobName());
			record.setDepartName(userList.get(0).getDepartName());
		}
	}
	request.setAttribute("AttendanceRercordAll_List", AttendanceRercordAll_List);
	return "hrm/attendanceRecordDetail_query";
}

}
