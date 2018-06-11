package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceAlasssetting;

public interface AttendanceAlasssettingMapper {
	
    int insert(AttendanceAlasssetting record);

    int insertSelective(AttendanceAlasssetting record);
    
    AttendanceAlasssetting selectByPrimaryKey(Integer classsetingid);
    
    List<AttendanceAlasssetting> serachAttendanceAlasssettingsByProperty(
			Map param);
    
    int 	updateByPrimaryKeySelective(AttendanceAlasssetting attendanceAlasssetting);
}