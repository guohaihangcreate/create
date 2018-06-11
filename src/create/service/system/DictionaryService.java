package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.Dictionary;


public interface DictionaryService {

	public int insertDictionarySelective(Dictionary dictionary);

	public List<Dictionary> pageListByParamMap(Map param);
	
	public int getMaxId();

	public int updateDictionaryInfoByPrimaryKeySelective(Dictionary dictionary);
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);
	
	public Dictionary selectByPrimaryKey(Integer id);
}
