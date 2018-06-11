package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.Treenodes;


public interface TreenodesMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Treenodes record);

    int insertSelective(Treenodes record);

    Treenodes selectByPrimaryKey(Integer id);
    
    
    Treenodes selectByPrimaryKeyAndPid(Integer id);
    
    
    List<Treenodes> selectByPid(Integer pid);
    
    List<Treenodes> selectTreenodesByMap(Map paraMap);
    
    List<Treenodes> selectTreeDateForList();
    
     List<Treenodes> findTreenodes(Integer roleId);

    int updateByPrimaryKeySelective(Treenodes record);

    int updateByPrimaryKey(Treenodes record);
    
    int isParent(Integer pid);
}