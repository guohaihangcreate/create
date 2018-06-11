package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.SalaryDetail;

public interface SalaryDetailService {

	public List<SalaryDetail> searchDepartByProperty(SalaryDetail salaryDetail);
	
	public int insertSalaryDetail(SalaryDetail salaryDetail);
	
	public SalaryDetail searchSalaryDetailByPrimaryKey(Integer sId);
	
	public int updateSalaryDetail(SalaryDetail salaryDetail);
	
	public int deleteByPrimaryKey(Integer sId);
	
	public List<SalaryDetail> selectSalaryByParamMap(Map paramMap);
	
}
