package create.service.crm;

import java.util.List;
import java.util.Map;

import create.model.crm.Zcproject;

public interface ZcprojectService {

	
    int deleteByPrimaryKey(Integer id);

    int insertZcprojectSelective(Zcproject record);
    
    List<Zcproject> selectZcprojectByParamMap(Map paramMap);

    Zcproject selectByPrimaryKey(Integer id);

    int updateZcprojectByPrimaryKeySelective(Zcproject record);

    
}
