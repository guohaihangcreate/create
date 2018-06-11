package create.service.waipai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.waipai.InterviewRecordMapper;
import create.model.waipai.InterviewRecord;

@Service("InterviewRecordServiceImpl")
public class InterviewRecordServiceImpl implements InterviewRecordService {

	private InterviewRecordMapper interviewRecordMapper;

	public InterviewRecordMapper getInterviewRecordMapper() {
		return interviewRecordMapper;
	}

	@Autowired
	public void setInterviewRecordMapper(
			InterviewRecordMapper interviewRecordMapper) {
		this.interviewRecordMapper = interviewRecordMapper;
	}

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(InterviewRecord record) {
		// TODO Auto-generated method stub
		return interviewRecordMapper.insert(record);
	}

	public int insertSelective(InterviewRecord record) {
		// TODO Auto-generated method stub
		return  interviewRecordMapper.insertSelective(record);
	}

	public InterviewRecord selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKey(InterviewRecord record) {
		// TODO Auto-generated method stub
		return interviewRecordMapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(InterviewRecord record) {
		// TODO Auto-generated method stub
		return interviewRecordMapper.updateByPrimaryKeySelective(record);
	}

	public List<InterviewRecord> selectInterviewRecordsByYaoqingID(Integer id) {
		// TODO Auto-generated method stub
		return interviewRecordMapper.selectInterviewRecordsByYaoqingID(id);
	}

	public List<InterviewRecord> selectInterviewRecordsByParam(Map paramap) {
		// TODO Auto-generated method stub
		return interviewRecordMapper.selectInterviewRecordsByParam(paramap);
	}

}
