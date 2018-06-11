package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.AttendanceClassTimesMapper;
import create.model.hrm.AttendanceClassTimes;

@Service("attendanceClassTimesService")
public class AttendanceClassTimesServiceImpl implements AttendanceClassTimesService{
	
	private AttendanceClassTimesMapper attendanceClassTimesMapper;

	

	public AttendanceClassTimesMapper getAttendanceClassTimesMapper() {
		return attendanceClassTimesMapper;
	}


	@Autowired
	public void setAttendanceClassTimesMapper(
			AttendanceClassTimesMapper attendanceClassTimesMapper) {
		this.attendanceClassTimesMapper = attendanceClassTimesMapper;
	}



	public int insertSelectiveAttendanceClassTimes(AttendanceClassTimes attendanceClassTimes){
		return attendanceClassTimesMapper.insertSelective(attendanceClassTimes);
	}


	@Override
	public AttendanceClassTimes serachAttendanceClassTimesByPK(Integer id) {
		// TODO Auto-generated method stub
		return attendanceClassTimesMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<AttendanceClassTimes> serachAttendanceClassTimesByProperty(
			Map param) {
		// TODO Auto-generated method stub
		return attendanceClassTimesMapper.serachAttendanceClassTimesByProperty(param);
	}


	@Override
	public int updateAttendanceClassTimesByPrimaryKeySelective(
			AttendanceClassTimes attendanceClassTimes) {
		// TODO Auto-generated method stub
		return attendanceClassTimesMapper.updateByPrimaryKeySelective(attendanceClassTimes);
	}
}
