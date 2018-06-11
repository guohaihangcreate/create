package create.service.crm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.crm.ZcprojectMapper;
import create.model.crm.Zcproject;
@Service("zcprojectService")
public class ZcprojectServiceImpl implements ZcprojectService {
	
	private ZcprojectMapper zcprojectMapper;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return zcprojectMapper.deleteByPrimaryKey(id);
	}

	public int insertZcprojectSelective(Zcproject record) {
		// TODO Auto-generated method stub
		return zcprojectMapper.insertSelective(record);
	}

	public Zcproject selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return zcprojectMapper.selectByPrimaryKey(id);
	}

	public List<Zcproject> selectZcprojectByParamMap(Map paramMap) {
		// TODO Auto-generated method stub
		return zcprojectMapper.selectZcprojectByParamMap(paramMap);
	}

	public int updateZcprojectByPrimaryKeySelective(Zcproject record) {
		// TODO Auto-generated method stub
		return zcprojectMapper.updateByPrimaryKeySelective(record);
	}

	public ZcprojectMapper getZcprojectMapper() {
		return zcprojectMapper;
	}
	@Autowired
	public void setZcprojectMapper(ZcprojectMapper zcprojectMapper) {
		this.zcprojectMapper = zcprojectMapper;
	}


}
