package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.AttendanceRercordAllMapper;
import create.model.hrm.AttendanceRercordAll;

@Service("attendanceRercordAll")
public class AttendanceRercordAllServiceImpl implements
		AttendanceRercordAllService {
	
	private AttendanceRercordAllMapper attendanceRercordAllMapper;

	public AttendanceRercordAllMapper getAttendanceRercordAllMapper() {
		return attendanceRercordAllMapper;
	}
	
	@Autowired
	public void setAttendanceRercordAllMapper(
			AttendanceRercordAllMapper attendanceRercordAllMapper) {
		this.attendanceRercordAllMapper = attendanceRercordAllMapper;
	}
	
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int insertAttendanceRercordAllSelective(AttendanceRercordAll record) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.insert(record);
	}
	
	@Override
	public AttendanceRercordAll selectAttendanceRercordAllByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public int updateAttendanceRercordAllByPrimaryKey(
			AttendanceRercordAll record) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateAttendanceRercordAllByPrimaryKeySelective(
			AttendanceRercordAll record) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<AttendanceRercordAll> queryAttendanceRecordAllByPropertys(
			Map paramMap) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.queryAttendanceRecordAllByPropertys(paramMap);
	}

	@Override
	public List attendanceMonthlyReport(Map paramMap) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.attendanceMonthlyReport(paramMap);
	}

	@Override
	public Long pageCounts(Map paramMap) {
		// TODO Auto-generated method stub
		return attendanceRercordAllMapper.pageCounts(paramMap);
	}

}
