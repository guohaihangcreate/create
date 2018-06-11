package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.UserGroupRelation;

public interface UserGroupRelationMapper {
	
    int deleteByPrimaryKey(Integer tugId);
    
    List<UserGroupRelation>   selectByProperty(UserGroupRelation userGroupRelation);
    
    public List<UserGroupRelation> selectByUserGroupRelationByParamMap(
			Map paramMap);
    
    int deleteByRoleID(Integer roleID);
    
    int insert(UserGroupRelation record);

    int insertSelective(UserGroupRelation record);

    UserGroupRelation selectByPrimaryKey(Integer tugId);
    
    List<Integer>   findUserGroupRelation(Integer tugId);

    int updateByPrimaryKeySelective(UserGroupRelation record);

    int updateByPrimaryKey(UserGroupRelation record);
    
    int deleteByProperyMap(Map map);
}