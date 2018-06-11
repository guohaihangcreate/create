package create.service.hrm;

import java.util.List;

import create.model.hrm.Function;

public interface SysFunService {
	
	public List<Function> searchFunByProperty(Function fun);
	
	public int insertFun(Function fun);
	
	public List<Function> funMenuesByParantID(Integer pid);
	
	public Function selectByPrimaryKey(Integer funid);

}
