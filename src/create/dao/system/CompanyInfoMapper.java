package create.dao.system;

import java.util.List;

import create.model.system.CompanyInfo;

public interface CompanyInfoMapper {
	
    int deleteByPrimaryKey(Integer companyid);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer companyid);

    int updateByPrimaryKeySelective(CompanyInfo record);
    
    List<CompanyInfo> selectCompanyByPropterty(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}