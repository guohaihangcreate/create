package create.service.hrm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.DepartMapper;
import create.model.hrm.Depart;
@Service("departService")
public class DepartmentServiceImpl implements DepartService {
	
	private DepartMapper deptMapper;


	public List<Depart> searchDepartByProperty(Depart dept) {
		// TODO Auto-generated method stub
		List<Depart> departs = deptMapper.searchDepartByProperty(dept);
		return departs;
	}
	
	public DepartMapper getDeptMapper() {
		return deptMapper;
	}
	@Autowired
	public void setDeptMapper(DepartMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	public int inDepartUser(Depart dept) {
		// TODO Auto-generated method stub
		return deptMapper.insertSelective(dept);
	}

	public Depart searchDepartByPrimaryKey(Integer deptId) {
		// TODO Auto-generated method stub
		return deptMapper.selectByPrimaryKey(deptId);
	}

	public int updateDepart(Depart dept) {
		// TODO Auto-generated method stub
		return deptMapper.updateByPrimaryKeySelective(dept);
	}

	public int deleteByPrimaryKey(Integer deptId) {
		// TODO Auto-generated method stub
		return this.deptMapper.deleteByPrimaryKey(deptId);
	}

	

	
}
