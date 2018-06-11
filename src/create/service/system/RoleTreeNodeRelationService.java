package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.RoleTreeNodeRelation;
import create.model.system.SysRole;

public interface RoleTreeNodeRelationService {
	
	public int insertRoleTreeNodeRelation(RoleTreeNodeRelation roleTreeNodeRelation); 
	
	int deleteByRoleID(Integer roleID);
	
	RoleTreeNodeRelation selectByPrimaryKey(Integer id);
	
	List<RoleTreeNodeRelation> getRoleTreeNodeRelationByProperty(RoleTreeNodeRelation roleTreeNodeRelation);
	
	List<RoleTreeNodeRelation> getRoleTreeNodeRelationByRole(SysRole role);
	
	public List<RoleTreeNodeRelation> findTreenodes(Integer roleId);
	
	
	List<RoleTreeNodeRelation> getRoleTreeNodeRelationByMap(Map map);
	

}
