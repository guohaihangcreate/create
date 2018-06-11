package create.controller.hrm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import create.model.hrm.AttendanceClass;
import create.model.hrm.AttendanceClassTimes;
import create.service.hrm.AttendanceClassService;
import create.service.hrm.AttendanceClassTimesService;
import create.service.hrm.AttendanceGroupService;
import create.service.hrm.AttendanceGroupclassRefSercice;
/*
 * 考勤班次获取
 */
@Controller
@RequestMapping("/attendanceClassController")
public class AttendanceClassController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private AttendanceClassTimesService attendanceClassTimesService;
	
	private AttendanceGroupclassRefSercice  attendanceGroupclassRefSercice;
	
	private AttendanceGroupService attendanceGroupService;
	

	private AttendanceClassService attendanceClassService;
	
	public AttendanceClassService getAttendanceClassService() {
		return attendanceClassService;
	}


	@Autowired
	public void setAttendanceClassService(
			AttendanceClassService attendanceClassService) {
		this.attendanceClassService = attendanceClassService;
	}



	@RequestMapping("/queryAttendanceClassList")
	public String queryAttendanceClassList(AttendanceClass attendanceClass, HttpServletRequest request) {
		Map param = new HashMap();
		param.put("classname", attendanceClass.getClassname());
		List<AttendanceClass> attendanceClass_list = attendanceClassService.serachAttendanceClasssByProperty(param);
		Map timeParam = new HashMap();
		for(AttendanceClass aClass:attendanceClass_list){
			timeParam.put("classId", aClass.getClassid());
			List<AttendanceClassTimes> attendanceClassTimesList = attendanceClassTimesService.serachAttendanceClassTimesByProperty(param);
			if(attendanceClassTimesList!=null&&attendanceClassTimesList.size()>0){
				Date restBeginTime =attendanceClassTimesList.get(0).getRestBeginTime();
				Date restEndTime =attendanceClassTimesList.get(0).getRestEndTime();
				aClass.setRest_begintime(restBeginTime.getHours()+":"+restBeginTime.getMinutes()+":"+restBeginTime.getSeconds());
				aClass.setRest_endtime(restEndTime.getHours()+":"+restEndTime.getMinutes()+":"+restEndTime.getSeconds());
			}
		}
		request.setAttribute("attendanceClass_list", attendanceClass_list);
		return "hrm/attendanceClassList";
	}

	

	public AttendanceClassTimesService getAttendanceClassTimesService() {
		return attendanceClassTimesService;
	}


	@Autowired
	public void setAttendanceClassTimesService(
			AttendanceClassTimesService attendanceClassTimesService) {
		this.attendanceClassTimesService = attendanceClassTimesService;
	}



	public AttendanceGroupclassRefSercice getAttendanceGroupclassRefSercice() {
		return attendanceGroupclassRefSercice;
	}
	@Autowired
	public void setAttendanceGroupclassRefSercice(
			AttendanceGroupclassRefSercice attendanceGroupclassRefSercice) {
		this.attendanceGroupclassRefSercice = attendanceGroupclassRefSercice;
	}

	public AttendanceGroupService getAttendanceGroupService() {
		return attendanceGroupService;
	}
	@Autowired
	public void setAttendanceGroupService(
			AttendanceGroupService attendanceGroupService) {
		this.attendanceGroupService = attendanceGroupService;
	}
	
	

}
