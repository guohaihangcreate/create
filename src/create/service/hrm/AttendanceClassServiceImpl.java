package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.AttendanceClassMapper;
import create.model.hrm.AttendanceClass;
@Service("attendanceClassService")
public class AttendanceClassServiceImpl implements AttendanceClassService{

	private AttendanceClassMapper attendanceClassMapper;
	
	@Override
	public int insertSelectiveAttendanceClass(AttendanceClass AttendanceClass) {
		// TODO Auto-generated method stub
		return attendanceClassMapper.insertSelective(AttendanceClass);
	}

	public AttendanceClassMapper getAttendanceClassMapper() {
		return attendanceClassMapper;
	}
	@Autowired
	public void setAttendanceClassMapper(AttendanceClassMapper attendanceClassMapper) {
		this.attendanceClassMapper = attendanceClassMapper;
	}

	@Override
	public AttendanceClass serachAttendanceClassGroupByPK(Integer classId) {
		// TODO Auto-generated method stub
		return this.attendanceClassMapper.selectByPrimaryKey(String.valueOf(classId));
	}

	@Override
	public List<AttendanceClass> serachAttendanceClasssByProperty(Map param) {
		// TODO Auto-generated method stub
		return this.attendanceClassMapper.serachAttendanceClasssByProperty(param);
	}

	@Override
	public int updateAttendanceClassByPrimaryKeySelective(
			AttendanceClass attendanceClass) {
		// TODO Auto-generated method stub
		return this.attendanceClassMapper.updateByPrimaryKeySelective(attendanceClass);
	}

}
