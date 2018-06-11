package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.KaoqinDetail;

public interface KaoqinDetailService {

	int insertKaoqinDetailSelective(KaoqinDetail kaoqinDetai);
	
	List<KaoqinDetail>   pageKaoQinDetailListByParamMap(Map paraMap);
}
