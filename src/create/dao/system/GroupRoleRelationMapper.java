package create.dao.system;

import create.model.system.GroupRoleRelation;

public interface GroupRoleRelationMapper {
    int deleteByPrimaryKey(Integer tgrId);

    int insert(GroupRoleRelation record);

    int insertSelective(GroupRoleRelation record);

    GroupRoleRelation selectByPrimaryKey(Integer tgrId);

    int updateByPrimaryKeySelective(GroupRoleRelation record);

    int updateByPrimaryKey(GroupRoleRelation record);
}