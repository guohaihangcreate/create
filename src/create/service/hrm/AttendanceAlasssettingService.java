package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceAlasssetting;
import create.model.hrm.AttendanceClass;
import create.model.hrm.AttendanceGroup;

public interface AttendanceAlasssettingService {
	
	public int insertSelectiveAttendanceAlasssetting(AttendanceAlasssetting attendanceAlasssetting);
	
    public AttendanceAlasssetting serachAttendanceAlasssettingByPK(Integer classsetingid);
	
	public List<AttendanceAlasssetting> serachAttendanceAlasssettingsByProperty(Map param);
	
	public int 	updateAttendanceAlasssettingByPrimaryKeySelective(AttendanceAlasssetting attendanceAlasssetting);

}
