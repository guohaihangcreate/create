package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceClassTimes;

public interface AttendanceClassTimesMapper {
	
    int deleteByPrimaryKey(Integer classId);

    int insert(AttendanceClassTimes record);

    int insertSelective(AttendanceClassTimes record);

    AttendanceClassTimes selectByPrimaryKey(Integer classId);
    
    List<AttendanceClassTimes> serachAttendanceClassTimesByProperty(
			Map param);

    int updateByPrimaryKeySelective(AttendanceClassTimes record);

    int updateByPrimaryKey(AttendanceClassTimes record);
}