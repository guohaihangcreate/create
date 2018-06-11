package create.service.hrm;

import java.util.List;

import create.model.system.CompanyInfo;

public interface CompanyInfoService {

	
	
	public int deleteByPrimaryKey(Integer companyid);
	
	public int insertSelective(CompanyInfo record);
	

	public  CompanyInfo selectByPrimaryKey(Integer companyid);

	public int updateByPrimaryKeySelective(CompanyInfo record);
	
	public List<CompanyInfo> selectCompanyByPropterty(CompanyInfo record);

	
}
