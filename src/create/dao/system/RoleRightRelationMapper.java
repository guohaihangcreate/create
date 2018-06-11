package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.RoleRightRelation;

public interface RoleRightRelationMapper {
	
    int deleteByRoleID(Integer roleId);
    
    int deleteByPrimaryKey(Integer trrId);

    int insert(RoleRightRelation record);

    int insertSelective(RoleRightRelation record);

    RoleRightRelation selectByPrimaryKey(Integer trrId);
    
    public List<RoleRightRelation> selectByRoleRightRelationByParamMap(Map paramMap);

    int updateByPrimaryKeySelective(RoleRightRelation record);

    int updateByPrimaryKey(RoleRightRelation record);
}