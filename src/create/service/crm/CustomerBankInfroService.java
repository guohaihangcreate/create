/**
 * 
 */
package create.service.crm;

import java.util.List;

import create.model.crm.CustomerBankInfro;

/**
 * @author guohaihang
 *
 */
public interface CustomerBankInfroService {

	public int insertCustomerBankInfroSelective(CustomerBankInfro customerBankInfro);

	public List<CustomerBankInfro> searchCustomerBankByProperty(CustomerBankInfro customerBankInfro);

	public int updateCustomerBankInfroByPrimaryKeySelective(CustomerBankInfro customerBankInfro);
	
	public int deleteCustomerById(Integer id);
	
	public CustomerBankInfro selectByPrimaryKey(Integer id);
}
