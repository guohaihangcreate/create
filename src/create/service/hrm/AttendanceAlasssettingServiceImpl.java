package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.AttendanceAlasssettingMapper;
import create.model.hrm.AttendanceAlasssetting;
@Service("attendanceAlasssettingService")
public class AttendanceAlasssettingServiceImpl implements AttendanceAlasssettingService {
	
	private AttendanceAlasssettingMapper attendanceAlasssettingMapper;

	public AttendanceAlasssettingMapper getAttendanceAlasssettingMapper() {
		return attendanceAlasssettingMapper;
	}
	@Autowired
	public void setAttendanceAlasssettingMapper(
			AttendanceAlasssettingMapper attendanceAlasssettingMapper) {
		this.attendanceAlasssettingMapper = attendanceAlasssettingMapper;
	}
	@Override
	public int insertSelectiveAttendanceAlasssetting(AttendanceAlasssetting attendanceAlasssetting) {
		// TODO Auto-generated method stub
		return this.attendanceAlasssettingMapper.insertSelective(attendanceAlasssetting);
	}
	@Override
	public AttendanceAlasssetting serachAttendanceAlasssettingByPK(
			Integer classsetingid) {
		// TODO Auto-generated method stub
		return this.attendanceAlasssettingMapper.selectByPrimaryKey(classsetingid);
	}
	@Override
	public List<AttendanceAlasssetting> serachAttendanceAlasssettingsByProperty(
			Map param) {
		// TODO Auto-generated method stub
		return this.attendanceAlasssettingMapper.serachAttendanceAlasssettingsByProperty(param);
	}
	@Override
	public int updateAttendanceAlasssettingByPrimaryKeySelective(
			AttendanceAlasssetting attendanceAlasssetting) {
		// TODO Auto-generated method stub
		return this.attendanceAlasssettingMapper.updateByPrimaryKeySelective(attendanceAlasssetting);
	}
}
