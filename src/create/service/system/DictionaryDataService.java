package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.Dictionarydata;


public interface DictionaryDataService {

	public int insertDictionaryDataSelective(Dictionarydata dictionaryData);

	public List<Dictionarydata> pageListByParamMap(Map param);

	public int updateDictionaryDataInfoByPrimaryKeySelective(Dictionarydata dictionaryData);
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);
	
	public Dictionarydata selectByPrimaryKey(Integer id);
}
