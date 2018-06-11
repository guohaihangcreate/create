package create.service.waipai;

import java.util.List;
import java.util.Map;

import create.model.waipai.JianLi;

public interface JianliService {

	public int insertJianLi(JianLi jl);
	
	public List<JianLi> QueryJianLiList(JianLi jl);
	
	
	public JianLi selectByPrimaryKey(Integer pId);
	
	public int updateJianLi(JianLi jl);
	
	public List<JianLi> selectJianLisByProperyForPage(Integer startPos,Integer pageSize);
	
	public int getJianLisCount(JianLi jl);
//	分页查询
	public List<JianLi> pageList(Long startIndex, Long endIndex,JianLi jl);
//	分页查询接受Map类型的参数
	public List<JianLi> pageListByParamMap(Map param);
	
//	通过拼接sql查询简历
	public List<JianLi> pageDataBySqlParamMap(Map param);
	
	
//	通过拼接sql查询简历数据总量
	public Long pageCountsBySqlParamMap(Map param);
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);

}
