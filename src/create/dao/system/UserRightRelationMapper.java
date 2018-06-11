package create.dao.system;

import create.model.system.UserRightRelation;

public interface UserRightRelationMapper {
    int deleteByPrimaryKey(Integer turId);

    int insert(UserRightRelation record);

    int insertSelective(UserRightRelation record);

    UserRightRelation selectByPrimaryKey(Integer turId);

    int updateByPrimaryKeySelective(UserRightRelation record);

    int updateByPrimaryKey(UserRightRelation record);
}