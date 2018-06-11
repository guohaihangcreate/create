package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.RoleRightRelationMapper;
import create.model.system.RoleRightRelation;

@Service("RoleRightRelationServiceImpl")
public class RoleRightRelationServiceImpl implements RoleRightRelationService {

	private RoleRightRelationMapper roleRightRelationMapper;

	public RoleRightRelationMapper getRoleRightRelationMapper() {
		return roleRightRelationMapper;
	}
	@Autowired
	public void setRoleRightRelationMapper(
			RoleRightRelationMapper roleRightRelationMapper) {
		this.roleRightRelationMapper = roleRightRelationMapper;
	}
	public List<RoleRightRelation> selectByRoleRightRelationByParamMap(
			Map paramMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
