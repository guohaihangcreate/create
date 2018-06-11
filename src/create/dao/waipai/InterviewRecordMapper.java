package create.dao.waipai;

import java.util.List;
import java.util.Map;

import create.model.waipai.InterviewRecord;

public interface InterviewRecordMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(InterviewRecord record);

    int insertSelective(InterviewRecord record);

    InterviewRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterviewRecord record);

    int updateByPrimaryKey(InterviewRecord record);
    
  //根据邀请id查询邀请详细
	List<InterviewRecord> selectInterviewRecordsByYaoqingID(Integer yqid);
	
	//根据邀请id查询邀请详细
	List<InterviewRecord> selectInterviewRecordsByParam(Map paramap);

}