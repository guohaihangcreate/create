package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.SalaryDetailMapper;
import create.model.hrm.SalaryDetail;
@Service("SalaryDetailService")
public class SalaryDetailServiceImpl implements SalaryDetailService {
	
	private SalaryDetailMapper salaryDetailMapper;

	

	public SalaryDetailMapper getSalaryDetailMapper() {
		return salaryDetailMapper;
	}
	@Autowired
	public void setSalaryDetailMapper(SalaryDetailMapper salaryDetailMapper) {
		this.salaryDetailMapper = salaryDetailMapper;
	}

	public int deleteByPrimaryKey(Integer sId) {
		// TODO Auto-generated method stub
		return salaryDetailMapper.deleteByPrimaryKey(sId);
	}

	public int insertSalaryDetail(SalaryDetail salaryDetail) {
		// TODO Auto-generated method stub
		return salaryDetailMapper.insertSelective(salaryDetail);
	}

	public List<SalaryDetail> searchDepartByProperty(SalaryDetail salaryDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	public SalaryDetail searchSalaryDetailByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return salaryDetailMapper.selectByPrimaryKey(id);
	}

	public int updateSalaryDetail(SalaryDetail salaryDetail) {
		// TODO Auto-generated method stub
		return salaryDetailMapper.updateByPrimaryKeySelective(salaryDetail);
	}
	
	public List<SalaryDetail> selectSalaryByParamMap(Map paramMap) {
		// TODO Auto-generated method stub
		return salaryDetailMapper.selectSalaryByParamMap(paramMap);
	}

}
