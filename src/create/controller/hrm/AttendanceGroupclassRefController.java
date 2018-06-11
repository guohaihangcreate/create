package create.controller.hrm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import create.service.hrm.AttendanceClassService;
import create.service.hrm.AttendanceClassTimesService;
import create.service.hrm.AttendanceGroupService;
import create.service.hrm.AttendanceGroupclassRefSercice;
@Controller
@RequestMapping("/attendanceGroupclassRefController")
public class AttendanceGroupclassRefController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	private AttendanceClassTimesService attendanceClassTimesService;
	
	private AttendanceGroupclassRefSercice  attendanceGroupclassRefSercice;
	
	private AttendanceGroupService attendanceGroupService;
	
	private AttendanceClassService attendanceClassService;

	

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
	public AttendanceClassService getAttendanceClassService() {
		return attendanceClassService;
	}
	@Autowired
	public void setAttendanceClassService(
			AttendanceClassService attendanceClassService) {
		this.attendanceClassService = attendanceClassService;
	}
}
