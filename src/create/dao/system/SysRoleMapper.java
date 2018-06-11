package create.dao.system;

import java.util.List;
import java.util.Map;

import create.model.system.SysRole;

public interface SysRoleMapper {
	
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);
    
    
    List<SysRole> selectByPropery(SysRole record);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
  //分页总条数
	public Long pageCounts(Map<String,Object> p);
}