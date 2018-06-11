package create.dao.crm;

import java.util.List;

import create.model.crm.ContactInfro;
import create.model.crm.CustomerBankInfro;

public interface CustomerBankInfroMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerBankInfro record);

    int insertSelective(CustomerBankInfro record);

    CustomerBankInfro selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerBankInfro record);
    
    List<CustomerBankInfro> searchCustomerBankByProperty(CustomerBankInfro record);

    int updateByPrimaryKey(CustomerBankInfro record);
    
}