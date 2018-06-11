package create.dao.hrm;

import java.util.List;

import create.model.hrm.Function;

public interface FunctionMapper {
	
    int deleteByPrimaryKey(Integer funid);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer funid);
    
    List<Function> searchFunctionByProperty(Function fun);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
    
    List<Function> funMenuesByParantID(Integer pid);
}