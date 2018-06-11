/**
 * 
 */
package create.service.crm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.crm.CustomerBankInfroMapper;
import create.model.crm.CustomerBankInfro;

/**
 * @author guohaihang
 *
 */
@Service("CustomerBankInfroService")
public class CustomerBankInfroServiceImpl implements CustomerBankInfroService {
	
	private CustomerBankInfroMapper  customerBankInfroMapper;

	/**
	 * 
	 */
	public CustomerBankInfroServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see create.service.crm.CustomerBankInfroService#insertCustomerBankInfroSelective(create.model.crm.CustomerBankInfro)
	 */
	public int insertCustomerBankInfroSelective(
			CustomerBankInfro customerBankInfro) {
		// TODO Auto-generated method stub
		return customerBankInfroMapper.insertSelective(customerBankInfro);
	}

	/* (non-Javadoc)
	 * @see create.service.crm.CustomerBankInfroService#searchCustomerByProperty(create.model.crm.CustomerBankInfro)
	 */
	public List<CustomerBankInfro> searchCustomerBankByProperty(
			CustomerBankInfro customerBankInfro) {
		// TODO Auto-generated method stub
		return customerBankInfroMapper.searchCustomerBankByProperty(customerBankInfro);
	}
	
	public CustomerBankInfro selectByPrimaryKey(Integer id){
		return  customerBankInfroMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see create.service.crm.CustomerBankInfroService#updateCustomerBankInfroByPrimaryKeySelective(create.model.crm.CustomerBankInfro)
	 */
	public int updateCustomerBankInfroByPrimaryKeySelective(
			CustomerBankInfro customerBankInfro) {
		// TODO Auto-generated method stub
		return customerBankInfroMapper.updateByPrimaryKeySelective(customerBankInfro);
	}

	public CustomerBankInfroMapper getCustomerBankInfroMapper() {
		return customerBankInfroMapper;
	}

	@Autowired
	public void setCustomerBankInfroMapper(
			CustomerBankInfroMapper customerBankInfroMapper) {
		this.customerBankInfroMapper = customerBankInfroMapper;
	}

	public int deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return this.customerBankInfroMapper.deleteByPrimaryKey(id);
	}

}
