package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceClass;

public interface AttendanceClassService {

	public int insertSelectiveAttendanceClass(AttendanceClass AttendanceClass);
	
	public AttendanceClass serachAttendanceClassGroupByPK(Integer classId);
	
	public List<AttendanceClass> serachAttendanceClasssByProperty(Map param);
	
    public int 	updateAttendanceClassByPrimaryKeySelective(AttendanceClass attendanceClass);
	
}
