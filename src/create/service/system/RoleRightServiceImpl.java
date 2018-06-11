package create.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.RoleRightRelationMapper;
import create.model.system.RoleRightRelation;

@Service("sysRoleRightServiceImpl")
public class RoleRightServiceImpl implements RoleRightService {

	private RoleRightRelationMapper roleRightRelationMapper;
	
	public int deleteByPrimaryKey(Integer trrId) {
		// TODO Auto-generated method stub
		return roleRightRelationMapper.deleteByPrimaryKey(trrId);
	}

	public int insert(RoleRightRelation record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(RoleRightRelation record) {
		// TODO Auto-generated method stub
		return roleRightRelationMapper.insertSelective(record);
	}

	public RoleRightRelation selectByPrimaryKey(Integer trrId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKey(RoleRightRelation record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(RoleRightRelation record) {
		// TODO Auto-generated method stub
		return roleRightRelationMapper.updateByPrimaryKeySelective(record);
	}


	public RoleRightRelationMapper getRoleRightRelationMapper() {
		return roleRightRelationMapper;
	}
	@Autowired
	public void setRoleRightRelationMapper(
			RoleRightRelationMapper roleRightRelationMapper) {
		this.roleRightRelationMapper = roleRightRelationMapper;
	}

	public int deleteByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return roleRightRelationMapper.deleteByRoleID(roleID);
	}

}
