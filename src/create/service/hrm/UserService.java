package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.User;



public interface UserService {


	public User getUserById(Integer id);
	
	
	public User selectByPrimaryKey(Integer id);

	public List<User> pageListByParamMap(Map param);
	
	public int insertUser(User user);
	
	public int upDateUser(User user);
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p);
}
