package create.service.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.XinziDetailMapper;
import create.model.hrm.XinziDetail;
@Service("xinziServiceImpl")
public class XinziServiceImpl implements XinziService {
	
	private XinziDetailMapper xinziDetailMapper;

	public XinziDetailMapper getXinziDetailMapper() {
		return xinziDetailMapper;
	}
	
	@Autowired
	public void setXinziDetailMapper(XinziDetailMapper xinziDetailMapper) {
		this.xinziDetailMapper = xinziDetailMapper;
	}

	public int insertSelective(XinziDetail record) {
		// TODO Auto-generated method stub
		return xinziDetailMapper.insertSelective(record);
	}
	
	

}
