package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.Dictionarydata;

public interface DictionarydataMapper {

	List<Dictionarydata> pageListByParamMap(Map param);

	// 分页总条数
	public Long pageCounts(Map<String, Object> p);

	int deleteByPrimaryKey(Integer id);

	int insert(Dictionarydata record);

	int insertSelective(Dictionarydata record);

	Dictionarydata selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Dictionarydata record);

	int updateByPrimaryKey(Dictionarydata record);
}