package create.dao.crm;

import java.util.List;
import java.util.Map;

import create.model.crm.CustomerInfo;
import create.model.crm.QueryCustomerInfo_model;
import create.model.waipai.JianLi;

public interface CustomerInfoMapper {
	
	
	List<CustomerInfo> pageListByParamMap(Map param);
	
	List<CustomerInfo> pageListByValidite(Map param);
	
	List<CustomerInfo> queryListByParamMap(Map param);
	
	// 分页总条数
	public Long pageCounts(Map<String, Object> p);
	
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    CustomerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);
    
    public List<QueryCustomerInfo_model> selectCustomerEngener(Map param);
    
    
    
}