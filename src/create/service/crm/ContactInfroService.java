/**
 * 
 */
package create.service.crm;

import java.util.List;

import create.dao.crm.ContactInfroMapper;
import create.model.crm.ContactInfro;
import create.model.crm.CustomerInfo;

/**
 * @author guohaihang
 *
 */
public interface ContactInfroService {
	
	public int insertContactInfroSelective(ContactInfro contactInfro);

	public List<ContactInfro> searchCustomerByProperty(ContactInfro contactInfro);

	public int updateCustomerInfoByPrimaryKeySelective(ContactInfro contactInfro);
	
	public ContactInfro selectByPrimaryKey(Integer id);

}
