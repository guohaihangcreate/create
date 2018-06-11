package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.AttendanceRercordAll;
import create.model.report.AttendanceMonthReport;

public interface AttendanceRercordAllMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(AttendanceRercordAll record);

    int insertSelective(AttendanceRercordAll record);

    AttendanceRercordAll selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AttendanceRercordAll record);

    int updateByPrimaryKey(AttendanceRercordAll record);
    
    List<AttendanceRercordAll> queryAttendanceRecordAllByPropertys(Map paramMap);
    
    List<AttendanceMonthReport> attendanceMonthlyReport(Map paramMap);
    
    Long pageCounts(Map paramMap);
}