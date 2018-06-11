package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.system.SysRoleMapper;
import create.model.system.SysRole;

@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl implements SysRoleService {

	private SysRoleMapper sysRoleMapper;

	public int insertRole(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleMapper.insertSelective(role);
	}
	
	public SysRole selectByPK(Integer roleId) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}
	
	public int queryRole(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleMapper.insertSelective(role);
	}
	
	public List<SysRole> selectByPropery(SysRole record) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByPropery(record);
	}
	
	public int updateRoleInfo(SysRole record) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	public SysRoleMapper getSysRoleMapper() {
		return sysRoleMapper;
	}
	@Autowired
	public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
		this.sysRoleMapper = sysRoleMapper;
	}

	public Long pageCounts(Map<String, Object> p) {
		// TODO Auto-generated method stub
		return sysRoleMapper.pageCounts(p);
	}


}
