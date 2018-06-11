package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.SalaryDetail;

public interface SalaryDetailMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(SalaryDetail record);

    int insertSelective(SalaryDetail record);

    SalaryDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalaryDetail record);

    int updateByPrimaryKey(SalaryDetail record);
    
    public List<SalaryDetail> selectSalaryByParamMap(Map paramMap);
}