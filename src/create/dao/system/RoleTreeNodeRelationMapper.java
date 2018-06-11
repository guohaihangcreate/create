package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.RoleTreeNodeRelation;
import create.model.system.SysRole;

public interface RoleTreeNodeRelationMapper {
	
	int deleteByRoleID(Integer roleID);
	
    int deleteByPrimaryKey(Integer id);

    int insert(RoleTreeNodeRelation record);

    int insertSelective(RoleTreeNodeRelation record);

    RoleTreeNodeRelation selectByPrimaryKey(Integer id);
    
    List<RoleTreeNodeRelation> getRoleTreeNodeRelationByProperty(RoleTreeNodeRelation roleTreeNodeRelation);
    
    List<RoleTreeNodeRelation> getRoleTreeNodeRelationByMap(Map map);
    
    List<RoleTreeNodeRelation> getRoleTreeNodeRelationByRole(SysRole role);
    
    List<RoleTreeNodeRelation> findTreeNodeRelation(Integer roleID);
    
    int updateByPrimaryKeySelective(RoleTreeNodeRelation record);

    int updateByPrimaryKey(RoleTreeNodeRelation record);
}