package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.Group;

public interface GroupMapper {
	
    int deleteByPrimaryKey(Integer tgId);

    int insert(Group record);

    int insertSelective(Group record);
    
    List<Group> selectByGroupByParamMap(Map paraMap);

    Group selectByPrimaryKey(Integer tgId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
    
}