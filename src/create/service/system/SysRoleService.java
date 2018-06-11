package create.service.system;

import java.util.List;
import java.util.Map;

import create.model.system.SysRole;

public interface SysRoleService {

	public int insertRole(SysRole role);
	
	public List<SysRole> selectByPropery(SysRole record);
	
	public SysRole selectByPK(Integer roleId);
	
	public int updateRoleInfo(SysRole record);
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);
}
