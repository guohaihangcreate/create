package create.dao.waipai;

import java.util.List;
import java.util.Map;

import create.model.report.MianshiInterviewReportModel;
import create.model.waipai.InterviewInvitation;

public interface InterviewInvitationMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(InterviewInvitation record);

	int insertSelective(InterviewInvitation record);

	InterviewInvitation selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(InterviewInvitation record);

	int updateByPrimaryKey(InterviewInvitation record);

	public List<InterviewInvitation> pageListByParamMap(Map paramMap);

	// 分页总条数
	public Long pageCounts(Map<String, Object> p);

	public List<MianshiInterviewReportModel> mianshiInterviewReport(Map param);

}