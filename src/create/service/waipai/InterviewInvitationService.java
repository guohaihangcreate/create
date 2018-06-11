package create.service.waipai;

import java.util.List;
import java.util.Map;

import create.model.report.MianshiInterviewReportModel;
import create.model.waipai.InterviewInvitation;

public interface InterviewInvitationService {
	//分页获取数据的条数
	public List<InterviewInvitation> pageListByParamMap(Map paramMap);

	// 分页总条数
	public Long pageCounts(Map<String, Object> p);
	//增加面试邀请详细记录、
	int insertSelective(InterviewInvitation record);
	
	//面试邀请统计报表
	public List<MianshiInterviewReportModel> mianshiInterviewReport(Map param);
	
	
}
