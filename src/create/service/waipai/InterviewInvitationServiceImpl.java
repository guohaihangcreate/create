package create.service.waipai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.waipai.InterviewInvitationMapper;
import create.model.report.MianshiInterviewReportModel;
import create.model.waipai.InterviewInvitation;

@Service("interviewInvitationServiceImpl")
public class InterviewInvitationServiceImpl implements
		InterviewInvitationService {

	private InterviewInvitationMapper interviewInvitationMapper;

	public InterviewInvitationMapper getInterviewInvitationMapper() {
		return interviewInvitationMapper;
	}

	@Autowired
	public void setInterviewInvitationMapper(
			InterviewInvitationMapper interviewInvitationMapper) {
		this.interviewInvitationMapper = interviewInvitationMapper;
	}

	public Long pageCounts(Map<String, Object> p) {
		// TODO Auto-generated method stub
		return interviewInvitationMapper.pageCounts(p);
	}

	public List<InterviewInvitation> pageListByParamMap(Map paramMap) {
		// TODO Auto-generated method stub
		return interviewInvitationMapper.pageListByParamMap(paramMap);
	}

	public int insertSelective(InterviewInvitation record) {
		// TODO Auto-generated method stub
		return interviewInvitationMapper.insertSelective(record);
	}

	public List<MianshiInterviewReportModel> mianshiInterviewReport(Map param) {
		// TODO Auto-generated method stub
		return interviewInvitationMapper.mianshiInterviewReport(param);
	}

}
