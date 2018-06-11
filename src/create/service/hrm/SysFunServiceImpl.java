package create.service.hrm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.FunctionMapper;
import create.model.hrm.Function;

@Service("SysFunService")
public class SysFunServiceImpl implements SysFunService{

	private FunctionMapper functionMapper;

	public FunctionMapper getFunctionMapper() {
		return functionMapper;
	}
	@Autowired
	public void setFunctionMapper(FunctionMapper functionMapper) {
		this.functionMapper = functionMapper;
	}
	public int insertFun(Function fun) {
		// TODO Auto-generated method stub
		return functionMapper.insertSelective(fun);
	}
	public List<Function> searchFunByProperty(Function fun) {
		// TODO Auto-generated method stub
		return functionMapper.searchFunctionByProperty(fun);
	}
	public List<Function> funMenuesByParantID(Integer pid) {
		// TODO Auto-generated method stub
		return functionMapper.funMenuesByParantID(pid);
	}
	public Function selectByPrimaryKey(Integer funid) {
		// TODO Auto-generated method stub
		return functionMapper.selectByPrimaryKey(funid);
	}
	
	
}
