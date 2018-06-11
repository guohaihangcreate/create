package create.service.hrm;

import java.util.List;
import java.util.Map;

import create.model.hrm.SysNotice;

public interface NoticeService {

	public int insertSelective(SysNotice notice);
	
	public List<SysNotice> querySysNoticeList(Map map);
	
	public SysNotice selectByPrimaryKey(Integer id);
	
	public int updateByPrimaryKeySelective(SysNotice record);
	
	public int deleteByPrimaryKey(Integer id);
	
}
