package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.GroupRightRelation;

public interface GroupRightRelationMapper {
	
    int deleteByPrimaryKey(Integer tgrId);

    int insert(GroupRightRelation record);

    int insertSelective(GroupRightRelation record);

    GroupRightRelation selectByPrimaryKey(Integer tgrId);

    int updateByPrimaryKeySelective(GroupRightRelation record);
    
    
    int updateByPrimaryKeySelectiveByMap(Map map);
    
    List<GroupRightRelation> selectByGroupRightRelationByMap(Map map);
    

    int updateByPrimaryKey(GroupRightRelation record);
    
    int belongRightCounts(Map paramMap);
}