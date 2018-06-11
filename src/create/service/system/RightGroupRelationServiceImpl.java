package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.GroupRightRelationMapper;
import create.model.system.GroupRightRelation;

@Service("rightGroupRelationServiceImpl")
public class RightGroupRelationServiceImpl implements RightGroupRelationService {

	GroupRightRelationMapper groupRightRelationMapper;

	public GroupRightRelationMapper getGroupRightRelationMapper() {
		return groupRightRelationMapper;
	}

	@Autowired
	public void setGroupRightRelationMapper(
			GroupRightRelationMapper groupRightRelationMapper) {
		this.groupRightRelationMapper = groupRightRelationMapper;
	}

	public int belongRightCounts(Map paramMap) {
		return groupRightRelationMapper.belongRightCounts(paramMap);
	}

	public int insertGroupRightRelationSelective(GroupRightRelation record) {
		// TODO Auto-generated method stub
		return groupRightRelationMapper.insertSelective(record);
	}

	public int updateRightGroupRelationMap(Map paraMap) {
		return groupRightRelationMapper.updateByPrimaryKeySelectiveByMap(paraMap);
	}
	
	public List<GroupRightRelation> selectByGroupRightRelationByMap(Map paraMap){
		return groupRightRelationMapper.selectByGroupRightRelationByMap(paraMap);
	}

	public int insertSelective(GroupRightRelation record) {
		// TODO Auto-generated method stub
		return groupRightRelationMapper.insertSelective(record);
	}

	public int deleteByPrimaryKey(Integer tgrId) {
		// TODO Auto-generated method stub
		return groupRightRelationMapper.deleteByPrimaryKey(tgrId);
	}

}
