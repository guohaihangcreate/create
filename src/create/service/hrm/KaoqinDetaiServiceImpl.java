package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.KaoqinDetailMapper;
import create.model.hrm.KaoqinDetail;
@Service("kaoqinDetaiServiceImpl")
public class KaoqinDetaiServiceImpl implements KaoqinDetailService {
	
	public KaoqinDetailMapper KaoqinDetailMapper;

	public int insertKaoqinDetailSelective(KaoqinDetail kaoqinDetai) {
		// TODO Auto-generated method stub
		return KaoqinDetailMapper.insertSelective(kaoqinDetai);
	}

	public KaoqinDetailMapper getKaoqinDetailMapper() {
		return KaoqinDetailMapper;
	}
	@Autowired
	public void setKaoqinDetailMapper(KaoqinDetailMapper kaoqinDetailMapper) {
		KaoqinDetailMapper = kaoqinDetailMapper;
	}

	public List<KaoqinDetail> pageKaoQinDetailListByParamMap(Map paraMap) {
		// TODO Auto-generated method stub
		return KaoqinDetailMapper.pageKaoQinDetailListByParamMap(paraMap);
	}

}
