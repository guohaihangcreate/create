package create.dao.crm;

import java.util.List;

import create.model.crm.ContactInfro;

public interface ContactInfroMapper {
	
	int deleteByPrimaryKey(Integer id);

	int insert(ContactInfro record);

	int insertSelective(ContactInfro record);

	ContactInfro selectByPrimaryKey(Integer id);
	
	List<ContactInfro> searchCustomerByProperty(ContactInfro record);
	

	int updateByPrimaryKeySelective(ContactInfro record);

	int updateByPrimaryKey(ContactInfro record);
}