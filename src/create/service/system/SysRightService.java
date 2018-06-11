package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.Right;
import create.model.system.SysRole;

public interface SysRightService {
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);

	public int insertRight(Right right);

	public List<Right> selectByProperyByParamMap(Map paramMap);

	public Right selectByPK(Integer trId);

	public int updateRightInfo(Right record);
	
	public int deleteByPrimaryKey(Integer trId);
	
	public List<Right> findByIdsMap(Map paramMap);
}
