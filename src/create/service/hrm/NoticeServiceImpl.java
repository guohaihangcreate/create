package create.service.hrm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.SysNoticeMapper;
import create.model.hrm.SysNotice;

@Service("NoticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{

	private SysNoticeMapper sysNoticeMapper;
	
	public int insertSelective(SysNotice notice) {
		// TODO Auto-generated method stub
		return this.sysNoticeMapper.insertSelective(notice);
	}
	
	public List<SysNotice> querySysNoticeList(Map map){
		return this.sysNoticeMapper.pageListByParamMap(map);
	}

	public SysNoticeMapper getSysNoticeMapper() {
		return sysNoticeMapper;
	}
	@Autowired
	public void setSysNoticeMapper(SysNoticeMapper sysNoticeMapper) {
		this.sysNoticeMapper = sysNoticeMapper;
	}

	public SysNotice selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.sysNoticeMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysNotice record) {
		// TODO Auto-generated method stub
		return this.sysNoticeMapper.updateByPrimaryKeySelective(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.sysNoticeMapper.deleteByPrimaryKey(id);
	}

}
