package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.DictionaryMapper;
import create.model.system.Dictionary;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	private DictionaryMapper dictionaryMapper;

	public DictionaryMapper getDictionaryMapper() {
		return dictionaryMapper;
	}

	@Autowired
	public void setDictionaryMapper(DictionaryMapper dictionaryMapper) {
		this.dictionaryMapper = dictionaryMapper;
	}

	public int insertDictionarySelective(Dictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryMapper.insertSelective(dictionary);
	}

	public Long pageCounts(Map<String, Object> p) {
		// TODO Auto-generated method stub
		return dictionaryMapper.pageCounts(p);
	}

	public List<Dictionary> pageListByParamMap(Map param) {
		// TODO Auto-generated method stub
		return dictionaryMapper.pageListByParamMap(param);
	}

	public Dictionary selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dictionaryMapper.selectByPrimaryKey(id);
	}

	public int updateDictionaryInfoByPrimaryKeySelective(Dictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryMapper.updateByPrimaryKeySelective(dictionary);
	}

	public int getMaxId() {
		// TODO Auto-generated method stub
		return dictionaryMapper.getMaxId();
	}
}
