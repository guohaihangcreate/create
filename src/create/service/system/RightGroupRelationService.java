package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.GroupRightRelation;

public interface RightGroupRelationService {

	int belongRightCounts(Map paramMap);
	
	int insertGroupRightRelationSelective(GroupRightRelation record);
	
	int updateRightGroupRelationMap(Map map);
	
	List<GroupRightRelation> selectByGroupRightRelationByMap(Map paraMap);
	
	int insertSelective(GroupRightRelation record);
	
	
	int deleteByPrimaryKey(Integer tgrId);
	
	
}
