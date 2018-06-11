package create.dao.system;

import create.model.system.UserTreeNodeRelation;

public interface UserTreeNodeRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTreeNodeRelation record);

    int insertSelective(UserTreeNodeRelation record);

    UserTreeNodeRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTreeNodeRelation record);

    int updateByPrimaryKey(UserTreeNodeRelation record);
}