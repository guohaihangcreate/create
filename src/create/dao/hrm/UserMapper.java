package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.User;



public interface UserMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> pageListByParamMap(Map param);
    
 // 分页总条数
	public Long pageCounts(Map<String, Object> p);
}