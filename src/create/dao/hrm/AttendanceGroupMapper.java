package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceGroup;

public interface AttendanceGroupMapper {
	
    int deleteByPrimaryKey(Integer groupId);

    int insert(AttendanceGroup record);

    int insertSelective(AttendanceGroup record);

    AttendanceGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(AttendanceGroup record);

    int updateByPrimaryKey(AttendanceGroup record);
    
    public List<AttendanceGroup> serachAttendanceGroupsByProperty(Map param);
}