package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceGroupclassRef;

public interface AttendanceGroupclassRefSercice {

	public int insertSelectiveAttendanceGroupclassRef(AttendanceGroupclassRef attendanceGroupclassRef);
	
	public AttendanceGroupclassRef serachAttendanceGroupclassRefByPK(Integer id);
	
	public List<AttendanceGroupclassRef> serachAttendanceGroupclassRefByProperty(Map param);
	
    public int 	updateAttendanceGroupclassRefByPrimaryKeySelective(AttendanceGroupclassRef attendanceGroupclassRef);
	
}
