package create.model.hrm;

import java.util.Date;

public class Depart {
	
    private Integer deptId;

    private String deptMak;

    private Integer pdeptId;

    private String deptName;

    private Integer deptDirector;

    private Date createTime;

    private Integer createby;

    private Integer flag;
    //所属公司信息
    private String yl1;

    private String yl2;
    
    private String dingtalkId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptMak() {
        return deptMak;
    }

    public void setDeptMak(String deptMak) {
        this.deptMak = deptMak == null ? null : deptMak.trim();
    }

    public Integer getPdeptId() {
        return pdeptId;
    }

    public void setPdeptId(Integer pdeptId) {
        this.pdeptId = pdeptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getDeptDirector() {
        return deptDirector;
    }

    public void setDeptDirector(Integer deptDirector) {
        this.deptDirector = deptDirector;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

	public String getDingtalkId() {
		return dingtalkId;
	}

	public void setDingtalkId(String dingtalkId) {
		this.dingtalkId = dingtalkId;
	}
}