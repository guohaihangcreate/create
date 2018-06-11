/**
 * 
 */
package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.PayrollMapper;
import create.model.hrm.Payroll;

/**
 * @author 郭海航
 *
 */
@Service("payrollService")
public class PayrollServiceImpl implements PayrollService {
	
	private PayrollMapper payrollMapper;


	
	public List<Payroll> pagePayrollListByParamMap(Map paramMap) {
		// TODO Auto-generated method stub
		return payrollMapper.pagePayrollListByParamMap(paramMap);
	}

	

	public PayrollMapper getPayrollMapper() {
		return payrollMapper;
	}
	
	@Autowired
	public void setPayrollMapper(PayrollMapper payrollMapper) {
		this.payrollMapper = payrollMapper;
	}



	public List<Payroll> pagePayrollReprotList(Map paramMap) {
		// TODO Auto-generated method stub
		return payrollMapper.pagePayrollReprotList(paramMap);
	}



	public int insertSelective(Payroll payroll) {
		// TODO Auto-generated method stub
		return payrollMapper.insertSelective(payroll);
	}



	public Long pageCounts(Map paramMap) {
		// TODO Auto-generated method stub
		return payrollMapper.pageCounts(paramMap);
	}
	
	public Payroll selectByPrimaryKey(Integer id){
		return payrollMapper.selectByPrimaryKey(id);
	}



	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return payrollMapper.deleteByPrimaryKey(id);
	}



	public int updatePayrollByPrimaryKey(Payroll record) {
		// TODO Auto-generated method stub
		return payrollMapper.updateByPrimaryKeySelective(record);
	}


}
