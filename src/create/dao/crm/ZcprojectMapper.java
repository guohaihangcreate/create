package create.dao.crm;

import java.util.List;
import java.util.Map;

import create.model.crm.Zcproject;

public interface ZcprojectMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Zcproject record);

    int insertSelective(Zcproject record);

    Zcproject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zcproject record);

    int updateByPrimaryKey(Zcproject record);
    
    List<Zcproject> selectZcprojectByParamMap(Map paramMap) ;
}