package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.Group;
import create.model.system.Right;

public interface RightGroupService {
	
	public int insertGroupSelective(Group record);
	
	public List<Group> selectByGroupByParamMap(Map paramMap);
	
	public Group selectByPrimaryKey(Integer tgId);
 

}
