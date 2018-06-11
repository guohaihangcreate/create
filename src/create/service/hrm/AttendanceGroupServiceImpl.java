package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.AttendanceGroupMapper;
import create.model.hrm.AttendanceGroup;

@Service("attendanceGroupService")
public class AttendanceGroupServiceImpl implements AttendanceGroupService{
	
	private AttendanceGroupMapper attendanceGroupMapper;

	public AttendanceGroupMapper getAttendanceGroupMapper() {
		return attendanceGroupMapper;
	}
	@Autowired
	public void setAttendanceGroupMapper(AttendanceGroupMapper attendanceGroupMapper) {
		this.attendanceGroupMapper = attendanceGroupMapper;
	}
	
	public int insertSelectiveAttendanceGroup(AttendanceGroup attendanceGroup) {
		// TODO Auto-generated method stub
		return this.attendanceGroupMapper.insertSelective(attendanceGroup);
	}
	
	public AttendanceGroup serachAttendanceGroupByPK(Integer groupId) {
		// TODO Auto-generated method stub
		return this.attendanceGroupMapper.selectByPrimaryKey(groupId);
	}
	
	
	public List<AttendanceGroup> serachAttendanceGroupsByProperty(Map param) {
		// TODO Auto-generated method stub
		return this.attendanceGroupMapper.serachAttendanceGroupsByProperty(param);
	}
	
	public int updateAttendanceGroupByPrimaryKeySelective(
			AttendanceGroup attendanceGroup) {
		// TODO Auto-generated method stub
		return this.attendanceGroupMapper.updateByPrimaryKeySelective(attendanceGroup);
	}

}
