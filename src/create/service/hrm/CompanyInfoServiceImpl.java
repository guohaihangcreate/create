package create.service.hrm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.CompanyInfoMapper;
import create.model.system.CompanyInfo;
@Service("companyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {
	
	private CompanyInfoMapper companyInfoMapper;

	public CompanyInfoMapper getCompanyInfoMapper() {
		return companyInfoMapper;
	}
	@Autowired
	public void setCompanyInfoMapper(CompanyInfoMapper companyInfoMapper) {
		this.companyInfoMapper = companyInfoMapper;
	}

	public int deleteByPrimaryKey(Integer companyid) {
		// TODO Auto-generated method stub
		return this.companyInfoMapper.deleteByPrimaryKey(companyid);
	}

	public int insertSelective(CompanyInfo record) {
		// TODO Auto-generated method stub
		return this.companyInfoMapper.insertSelective(record);
	}


	public CompanyInfo selectByPrimaryKey(Integer companyid) {
		// TODO Auto-generated method stub
		return this.companyInfoMapper.selectByPrimaryKey(companyid);
	}

	public int updateByPrimaryKeySelective(CompanyInfo record) {
		// TODO Auto-generated method stub
		return this.companyInfoMapper.updateByPrimaryKeySelective(record);
	}
	public List<CompanyInfo> selectCompanyByPropterty(CompanyInfo record) {
		// TODO Auto-generated method stub
		return this.companyInfoMapper.selectCompanyByPropterty(record);
	}

}
