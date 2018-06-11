package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceGroup;

public interface AttendanceGroupService {

	public int insertSelectiveAttendanceGroup(AttendanceGroup attendanceGroup);
	
	public AttendanceGroup serachAttendanceGroupByPK(Integer groupId);
	
	public List<AttendanceGroup> serachAttendanceGroupsByProperty(Map param);
	
    public int 	updateAttendanceGroupByPrimaryKeySelective(AttendanceGroup attendanceGroup);
	
}
