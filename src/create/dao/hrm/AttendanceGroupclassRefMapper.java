package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceGroupclassRef;

public interface AttendanceGroupclassRefMapper {
	
    int deleteByPrimaryKey(Integer groupclassid);

    int insert(AttendanceGroupclassRef record);

    int insertSelective(AttendanceGroupclassRef record);

    AttendanceGroupclassRef selectByPrimaryKey(Integer groupclassid);

    int updateByPrimaryKeySelective(AttendanceGroupclassRef record);

    int updateByPrimaryKey(AttendanceGroupclassRef record);
    
    List<AttendanceGroupclassRef> serachAttendanceGroupclassRefByProperty(Map param);
}