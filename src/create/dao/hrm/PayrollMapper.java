package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.Payroll;

public interface PayrollMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payroll record);

    int insertSelective(Payroll record);

    Payroll selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Payroll record);

    int updateByPrimaryKey(Payroll record);
    
    public List<Payroll> pagePayrollListByParamMap(Map paramMap);
    
    public List<Payroll> pagePayrollReprotList(Map paramMap);
    
    public Long pageCounts(Map paramMap);
}