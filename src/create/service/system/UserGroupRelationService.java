package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.RoleRightRelation;
import create.model.system.UserGroupRelation;

public interface UserGroupRelationService {
	
	public int insertUserGroupRelation(UserGroupRelation userGroupRelation);
	
	int deleteByRoleID(Integer roleID);
	
	List<UserGroupRelation>   selectByProperty(UserGroupRelation userGroupRelation);
	
	public List<UserGroupRelation> selectByUserGroupRelationByParamMap(Map paramMap);
	
	public List<Integer> findUserGroupRelation(Integer userID);
	
	int deleteByProperyMap(Map map);
	
}
