package create.dao.waipai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import create.model.waipai.JianLi;

public interface JianLiMapper {

	int deleteByPrimaryKey(Integer pId);

	int insert(JianLi record);

	int insertSelective(JianLi record);

	JianLi selectByPrimaryKey(Integer pId);

	List<JianLi> selectByPropery(JianLi jl);

	int updateByPrimaryKeySelective(JianLi record);

	int updateByPrimaryKey(JianLi record);

	/**
	 * get test bean by UID.
	 * 
	 * @param id
	 * @return
	 */
	List<JianLi> selectJianLisByProperyForPage(@Param("startIndex")
	Integer startPos, @Param("endIndex")
	Integer pageSize);

	int getJianLisCount(JianLi jl);

	public List<JianLi> pageList(@Param("startIndex")
	Long startIndex, @Param("endIndex")
	Long endIndex, JianLi jl);

	public List<JianLi> pageListByParamMap(Map paramMap);

	// 分页总条数
	public Long pageCounts(Map<String, Object> p);

	// 通过拼接sql查询简历
	public List<JianLi> pageDataBySqlParamMap(Map param);
	
	
//	通过拼接sql查询简历数据总量
	public Long pageCountsBySqlParamMap(Map param);
}