package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.RoleRightRelation;

public interface RoleRightRelationService {
	
	public List<RoleRightRelation> selectByRoleRightRelationByParamMap(Map paramMap);

}
