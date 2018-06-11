package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.Dictionary;

public interface DictionaryMapper {

	List<Dictionary> pageListByParamMap(Map param);

	// 分页总条数
	public Long pageCounts(Map<String, Object> p);
	
	public int getMaxId();

	int deleteByPrimaryKey(Integer id);

	int insert(Dictionary record);

	int insertSelective(Dictionary record);

	Dictionary selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Dictionary record);

	int updateByPrimaryKey(Dictionary record);
}