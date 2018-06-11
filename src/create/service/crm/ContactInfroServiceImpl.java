/**
 * 
 */
package create.service.crm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.crm.ContactInfroMapper;
import create.model.crm.ContactInfro;

/**
 * @author guohaihang
 * 
 */
@Service("contactInfroService")
public class ContactInfroServiceImpl implements ContactInfroService {

	private ContactInfroMapper contactInfroMapper;

	public ContactInfroMapper getContactInfroMapper() {
		return contactInfroMapper;
	}

	@Autowired
	public void setContactInfroMapper(ContactInfroMapper contactInfroMapper) {
		this.contactInfroMapper = contactInfroMapper;
	}

	/**
	 * 
	 */
	public ContactInfroServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see create.service.crm.ContactInfroService#insertContactInfroSelective(create.model.crm.ContactInfro)
	 */
	public int insertContactInfroSelective(ContactInfro contactInfro) {
		// TODO Auto-generated method stub
		return contactInfroMapper.insertSelective(contactInfro);
	}
	
	public ContactInfro selectByPrimaryKey(Integer id){
		return contactInfroMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see create.service.crm.ContactInfroService#searchCustomerByProperty(create.model.crm.ContactInfro)
	 */
	public List<ContactInfro> searchCustomerByProperty(ContactInfro contactInfro) {
		// TODO Auto-generated method stub
		return contactInfroMapper.searchCustomerByProperty(contactInfro);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see create.service.crm.ContactInfroService#updateCustomerInfoByPrimaryKeySelective(create.model.crm.ContactInfro)
	 */
	public int updateCustomerInfoByPrimaryKeySelective(ContactInfro contactInfro) {
		// TODO Auto-generated method stub
		return contactInfroMapper.updateByPrimaryKeySelective(contactInfro);
	}

}
