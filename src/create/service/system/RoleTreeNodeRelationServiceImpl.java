package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.RoleTreeNodeRelationMapper;
import create.model.system.RoleTreeNodeRelation;
import create.model.system.SysRole;

@Service("RoleTreeNodeRelationServiceImpl")
public class RoleTreeNodeRelationServiceImpl implements
		RoleTreeNodeRelationService {
	
	private RoleTreeNodeRelationMapper roleTreeNodeRelationMapper;

	public int insertRoleTreeNodeRelation(
			RoleTreeNodeRelation roleTreeNodeRelation) {
		// TODO Auto-generated method stub
		return roleTreeNodeRelationMapper.insertSelective(roleTreeNodeRelation);
	}

	public RoleTreeNodeRelationMapper getRoleTreeNodeRelationMapper() {
		return roleTreeNodeRelationMapper;
	}
	@Autowired
	public void setRoleTreeNodeRelationMapper(
			RoleTreeNodeRelationMapper roleTreeNodeRelationMapper) {
		this.roleTreeNodeRelationMapper = roleTreeNodeRelationMapper;
	}

	public int deleteByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return this.roleTreeNodeRelationMapper.deleteByRoleID(roleID);
	}
	
	
	public List<RoleTreeNodeRelation> getRoleTreeNodeRelationByProperty(RoleTreeNodeRelation roleTreeNodeRelation) {
		// TODO Auto-generated method stub
		return this.roleTreeNodeRelationMapper.getRoleTreeNodeRelationByProperty(roleTreeNodeRelation);
	}
	
	public RoleTreeNodeRelation selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.roleTreeNodeRelationMapper.selectByPrimaryKey(id);
	}

	public List<RoleTreeNodeRelation> getRoleTreeNodeRelationByRole(SysRole role) {
		// TODO Auto-generated method stub
		return this.roleTreeNodeRelationMapper.getRoleTreeNodeRelationByRole(role);
	}

	public List<RoleTreeNodeRelation> findTreenodes(Integer roleId) {
		// TODO Auto-generated method stub
		return this.roleTreeNodeRelationMapper.findTreeNodeRelation(roleId);
	}

	public List<RoleTreeNodeRelation> getRoleTreeNodeRelationByMap(Map map) {
		// TODO Auto-generated method stub
		return this.roleTreeNodeRelationMapper.getRoleTreeNodeRelationByMap(map);
	}

}
