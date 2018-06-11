package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceClass;

public interface AttendanceClassMapper {
	
    int deleteByPrimaryKey(String classid);

    int insert(AttendanceClass record);

    int insertSelective(AttendanceClass record);

    AttendanceClass selectByPrimaryKey(String classid);

    int updateByPrimaryKeySelective(AttendanceClass record);

    int updateByPrimaryKey(AttendanceClass record);
    
    List<AttendanceClass> serachAttendanceClasssByProperty(Map param);
}