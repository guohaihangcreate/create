package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.UserGroupRelationMapper;
import create.model.system.UserGroupRelation;

@Service("UserGroupRelationServiceImpl")
public class UserGroupRelationServiceImpl implements UserGroupRelationService {
	
	private UserGroupRelationMapper userGroupRelationMapper;
	
	
	
	public List<Integer> findUserGroupRelation(
			Integer userId) {
		// TODO Auto-generated method stub
		return userGroupRelationMapper.findUserGroupRelation(userId);
	}
	

	public int insertUserGroupRelation(UserGroupRelation userGroupRelation) {
		// TODO Auto-generated method stub
		return userGroupRelationMapper.insertSelective(userGroupRelation);
	}
	
	public List<UserGroupRelation> selectByProperty(
			UserGroupRelation userGroupRelation) {
		// TODO Auto-generated method stub
		return userGroupRelationMapper.selectByProperty(userGroupRelation);
	}

	public int deleteByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return this.userGroupRelationMapper.deleteByRoleID(roleID);
	}

	public UserGroupRelationMapper getUserGroupRelationMapper() {
		return userGroupRelationMapper;
	}
	@Autowired
	public void setUserGroupRelationMapper(
			UserGroupRelationMapper userGroupRelationMapper) {
		this.userGroupRelationMapper = userGroupRelationMapper;
	}


	public List<UserGroupRelation> selectByUserGroupRelationByParamMap(
			Map paramMap) {
		// TODO Auto-generated method stub
		return this.userGroupRelationMapper.selectByUserGroupRelationByParamMap(paramMap);
	}


	public int deleteByProperyMap(Map map) {
		// TODO Auto-generated method stub
		return this.userGroupRelationMapper.deleteByProperyMap(map);
	}

}
