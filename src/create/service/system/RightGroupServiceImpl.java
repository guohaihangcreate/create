package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.GroupMapper;
import create.model.system.Group;
import create.model.system.Right;

@Service("rightGroupServiceImpl")
public class RightGroupServiceImpl implements RightGroupService {
	
	private GroupMapper groupMapper;

	public GroupMapper getGroupMapper() {
		return groupMapper;
	}
	@Autowired
	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}
	public int insertGroupSelective(Group record) {
		// TODO Auto-generated method stub
		return groupMapper.insert(record);
	}
	public List<Group> selectByGroupByParamMap(Map paramMap) {
		// TODO Auto-generated method stub
		return groupMapper.selectByGroupByParamMap(paramMap);
	}
	public Group selectByPrimaryKey(Integer tgId) {
		// TODO Auto-generated method stub
		return groupMapper.selectByPrimaryKey(tgId);
	}
	
	
}
