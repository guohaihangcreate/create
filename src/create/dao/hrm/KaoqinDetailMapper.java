package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.KaoqinDetail;

public interface KaoqinDetailMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(KaoqinDetail record);

    int insertSelective(KaoqinDetail record);

    KaoqinDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KaoqinDetail record);

    int updateByPrimaryKey(KaoqinDetail record);
    
    List<KaoqinDetail>   pageKaoQinDetailListByParamMap(Map paraMap);
}