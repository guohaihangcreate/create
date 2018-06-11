package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.DictionarydataMapper;
import create.model.system.Dictionarydata;

@Service("dictionaryDataService")
public class DictionaryDataServiceImpl implements DictionaryDataService {

	private DictionarydataMapper dictionarydataMapper;

	
	
	
	public DictionarydataMapper getDictionarydataMapper() {
		return dictionarydataMapper;
	}
	@Autowired
	public void setDictionarydataMapper(DictionarydataMapper dictionarydataMapper) {
		this.dictionarydataMapper = dictionarydataMapper;
	}
	public int insertDictionaryDataSelective(Dictionarydata dictionaryData) {
		// TODO Auto-generated method stub
		return dictionarydataMapper.insertSelective(dictionaryData);
	}
	public Long pageCounts(Map<String, Object> p) {
		// TODO Auto-generated method stub
		return dictionarydataMapper.pageCounts(p);
	}
	public List<Dictionarydata> pageListByParamMap(Map param) {
		// TODO Auto-generated method stub
		return dictionarydataMapper.pageListByParamMap(param);
	}
	public Dictionarydata selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dictionarydataMapper.selectByPrimaryKey(id);
	}
	public int updateDictionaryDataInfoByPrimaryKeySelective(
			Dictionarydata dictionaryData) {
		// TODO Auto-generated method stub
		return dictionarydataMapper.updateByPrimaryKeySelective(dictionaryData);
	}
	
}
