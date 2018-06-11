package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.Right;

public interface RightMapper {
	
    int deleteByPrimaryKey(Integer trId);

    int insert(Right record);

    int insertSelective(Right record);

    Right selectByPrimaryKey(Integer trId);
    
    List<Right> selectByProperyByParamMap(Map paramMap);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);
    
    //分页总条数
	public Long pageCounts(Map<String,Object> p);
	
	public List<Right> findByIdsMap(Map paramMap);

}