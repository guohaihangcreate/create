package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.RightMapper;
import create.model.system.Right;

@Service("sysRightServiceImpl")
public class SysRightServiceImpl  implements SysRightService {

	private RightMapper rightMapper;
	
	public RightMapper getRightMapper() {
		return rightMapper;
	}
	@Autowired
	public void setRightMapper(RightMapper rightMapper) {
		this.rightMapper = rightMapper;
	}

	public int insertRight(Right right) {
		// TODO Auto-generated method stub
		return rightMapper.insertSelective(right);
	}

	public Right selectByPK(Integer trId) {
		// TODO Auto-generated method stub
		return rightMapper.selectByPrimaryKey(trId);
	}

	public List<Right> selectByProperyByParamMap(Map paramMap) {
		// TODO Auto-generated method stub
		return rightMapper.selectByProperyByParamMap(paramMap);
	}

	public int updateRightInfo(Right record) {
		// TODO Auto-generated method stub
		return rightMapper.updateByPrimaryKeySelective(record);
	}
	public Long pageCounts(Map<String, Object> p) {
		// TODO Auto-generated method stub
		return rightMapper.pageCounts(p);
	}
	public int deleteByPrimaryKey(Integer trId) {
		// TODO Auto-generated method stub
		return rightMapper.deleteByPrimaryKey(trId);
	}
	public List<Right> findByIdsMap(Map paramMap) {
		// TODO Auto-generated method stub
		return rightMapper.findByIdsMap(paramMap);
	}

}
