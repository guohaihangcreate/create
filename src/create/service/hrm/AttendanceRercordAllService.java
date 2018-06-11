package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceRercordAll;

public interface AttendanceRercordAllService {
	
	Long pageCounts(Map paramMap);

    int deleteByPrimaryKey(String id);

    int insertAttendanceRercordAllSelective(AttendanceRercordAll record);
    
    List<AttendanceRercordAll> queryAttendanceRecordAllByPropertys(Map paramMap);

    AttendanceRercordAll selectAttendanceRercordAllByPrimaryKey(String id);

    int updateAttendanceRercordAllByPrimaryKeySelective(AttendanceRercordAll record);

    int updateAttendanceRercordAllByPrimaryKey(AttendanceRercordAll record);
    
    List attendanceMonthlyReport(Map paramMap);
    
}
