package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.AttendanceGroupclassRefMapper;
import create.model.hrm.AttendanceGroupclassRef;

@Service("attendanceGroupclassRefSercice")
public class AttendanceGroupclassRefSerciceImpl implements AttendanceGroupclassRefSercice{

	private AttendanceGroupclassRefMapper attendanceGroupclassRefMapper;

	public AttendanceGroupclassRefMapper getAttendanceGroupclassRefMapper() {
		return attendanceGroupclassRefMapper;
	}
	@Autowired
	public void setAttendanceGroupclassRefMapper(
			AttendanceGroupclassRefMapper attendanceGroupclassRefMapper) {
		this.attendanceGroupclassRefMapper = attendanceGroupclassRefMapper;
	}
	@Override
	public int insertSelectiveAttendanceGroupclassRef(
			AttendanceGroupclassRef attendanceGroupclassRef) {
		// TODO Auto-generated method stub
		return this.attendanceGroupclassRefMapper.insertSelective(attendanceGroupclassRef);
	}
	@Override
	public AttendanceGroupclassRef serachAttendanceGroupclassRefByPK(Integer id) {
		// TODO Auto-generated method stub
		return this.attendanceGroupclassRefMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<AttendanceGroupclassRef> serachAttendanceGroupclassRefByProperty(
			Map param) {
		// TODO Auto-generated method stub
		return this.attendanceGroupclassRefMapper.serachAttendanceGroupclassRefByProperty(param);
	}
	@Override
	public int updateAttendanceGroupclassRefByPrimaryKeySelective(
			AttendanceGroupclassRef attendanceGroupclassRef) {
		// TODO Auto-generated method stub
		return this.attendanceGroupclassRefMapper.updateByPrimaryKeySelective(attendanceGroupclassRef);
	}
}
