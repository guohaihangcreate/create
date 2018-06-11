/**
 * 
 */
package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.Payroll;

/**
 * @author 郭海航
 *
 */
public interface PayrollService {
	
	public List<Payroll> pagePayrollListByParamMap(Map paramMap);
	
	public List<Payroll> pagePayrollReprotList(Map paramMap);

	public int insertSelective(Payroll payroll);
	
	public Long pageCounts(Map paramMap);
	
	public Payroll selectByPrimaryKey(Integer id);
	
	public int deleteByPrimaryKey(Integer id);
	
	public int updatePayrollByPrimaryKey(Payroll record);

}
