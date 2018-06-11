package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.UserMapper;
import create.model.hrm.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return 	 userMapper.selectByPrimaryKey(id);
	}

	public List<User> pageListByParamMap(Map param) {
		// TODO Auto-generated method stub
		return userMapper.pageListByParamMap(param);
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	public int upDateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	//分页总条数
	public Long pageCounts(Map<String,Object> p){
		return userMapper.pageCounts(p);
	}

	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	

	

}
