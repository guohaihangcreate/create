/**
 * 
 */
package create.service.crm;

import java.util.List;
import java.util.Map;

import create.model.crm.CustomerInfo;
import create.model.crm.QueryCustomerInfo_model;

/**
 * @author guohaihang
 * 
 */
public interface CustomerInfoService {

	public int insertCustomerSelective(CustomerInfo customer);

	public List<CustomerInfo> pageListByParamMap(Map param);
	
	public List<CustomerInfo> queryListByParamMap(Map param);

	public int updateCustomerInfoByPrimaryKeySelective(CustomerInfo customer);
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);
	
	public CustomerInfo selectByPrimaryKey(Integer id);
	
	public List<QueryCustomerInfo_model> selectCustomerEngener(Map param);
	
	List<CustomerInfo> pageListByValidite(Map param);
	

}
