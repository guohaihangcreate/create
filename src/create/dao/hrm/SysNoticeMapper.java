package create.dao.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.SysNotice;

public interface SysNoticeMapper {
	
    int deleteByPrimaryKey(Integer id);
    
    List<SysNotice> pageListByParamMap(Map map);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    SysNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);
}