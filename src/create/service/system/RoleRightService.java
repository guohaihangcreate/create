package create.service.system;

import create.model.system.RoleRightRelation;

public interface RoleRightService {

	int deleteByPrimaryKey(Integer trrId);
	
	int deleteByRoleID(Integer roleID);
	

	int insert(RoleRightRelation record);

	int insertSelective(RoleRightRelation record);

	RoleRightRelation selectByPrimaryKey(Integer trrId);

	int updateByPrimaryKeySelective(RoleRightRelation record);

	int updateByPrimaryKey(RoleRightRelation record);
}
