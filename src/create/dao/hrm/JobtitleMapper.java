package create.dao.hrm;

import create.model.hrm.Jobtitle;

public interface JobtitleMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(Jobtitle record);

    int insertSelective(Jobtitle record);

    Jobtitle selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(Jobtitle record);

    int updateByPrimaryKey(Jobtitle record);
}