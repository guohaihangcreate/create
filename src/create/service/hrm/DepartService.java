package create.service.hrm;

import java.util.List;

import create.model.hrm.Depart;
import create.model.hrm.User;

public interface DepartService {

	public List<Depart> searchDepartByProperty(Depart dept);
	
	public int inDepartUser(Depart dept);
	
	public Depart searchDepartByPrimaryKey(Integer deptId);
	
	public int updateDepart(Depart dept);
	
	public int deleteByPrimaryKey(Integer deptId);
	
	
	
	
}
