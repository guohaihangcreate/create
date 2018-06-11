package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceClassTimes;
import create.model.hrm.AttendanceGroup;

public interface AttendanceClassTimesService {
	
	public int insertSelectiveAttendanceClassTimes(AttendanceClassTimes attendanceClassTimes);
	
	public AttendanceClassTimes serachAttendanceClassTimesByPK(Integer id);
	
	public List<AttendanceClassTimes> serachAttendanceClassTimesByProperty(Map param);
	
    public int 	updateAttendanceClassTimesByPrimaryKeySelective(AttendanceClassTimes attendanceClassTimes);

}
