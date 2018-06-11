/**
 * 
 */
package create.service.crm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.crm.CustomerInfoMapper;
import create.model.crm.CustomerInfo;
import create.model.crm.QueryCustomerInfo_model;

/**
 * @author guohaihang
 *
 */
@Service("customerInfoService")
public class CustomerInfoServiceImpl implements CustomerInfoService {
	
	private CustomerInfoMapper customerInfoMapper;

	public int insertCustomerSelective(CustomerInfo customer) {
		// TODO Auto-generated method stub
		customerInfoMapper.insertSelective(customer);
		return customer.getId();
	}

	// 分页查询接受Map类型的参数
	public List<CustomerInfo> pageListByParamMap(Map param) {
		return this.customerInfoMapper.pageListByParamMap(param);
	}
	
	// 分页总条数
	public Long pageCounts(Map<String, Object> p) {
		return customerInfoMapper.pageCounts(p);
	}

	public int updateCustomerInfoByPrimaryKeySelective(CustomerInfo customer) {
		// TODO Auto-generated method stub
		return customerInfoMapper.updateByPrimaryKeySelective(customer);
	}

	public CustomerInfoMapper getCustomerInfoMapper() {
		return customerInfoMapper;
	}
	
	@Autowired
	public void setCustomerInfoMapper(CustomerInfoMapper customerInfoMapper) {
		this.customerInfoMapper = customerInfoMapper;
	}

	public CustomerInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return customerInfoMapper.selectByPrimaryKey(id);
	}

	public List<CustomerInfo> queryListByParamMap(Map param) {
		// TODO Auto-generated method stub
		return customerInfoMapper.queryListByParamMap(param);
	}

	public List<QueryCustomerInfo_model> selectCustomerEngener(Map param) {
		// TODO Auto-generated method stub
		return customerInfoMapper.selectCustomerEngener(param);
	}

	public List<CustomerInfo> pageListByValidite(Map param) {
		// TODO Auto-generated method stub
		return customerInfoMapper.pageListByValidite(param);
	}

}
