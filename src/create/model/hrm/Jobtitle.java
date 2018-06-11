package create.model.hrm;

import java.util.Date;

public class Jobtitle {
    private Integer jobId;

    private String jobName;

    private String jobMark;

    private Date createtime;

    private String createby;

    private String yl1;

    private String yl2;

    private Integer flag;

    private Integer owerdept;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobMark() {
        return jobMark;
    }

    public void setJobMark(String jobMark) {
        this.jobMark = jobMark == null ? null : jobMark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getYl1() {
        return yl1;
    }

    public void setYl1(String yl1) {
        this.yl1 = yl1 == null ? null : yl1.trim();
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2 == null ? null : yl2.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getOwerdept() {
        return owerdept;
    }

    public void setOwerdept(Integer owerdept) {
        this.owerdept = owerdept;
    }
}