package create.model.hrm;

import java.util.Date;

public class KaoqinDetail {
	
    private Integer id;

    private Integer pollid;

    private Integer userid;
    
    private String userName;

    private Date kqdate;

    private Float qqsc;

    private String qqyy;

    private Float jbsc;
    //打卡时间
    private Date dktime;
    //考勤时间
    private Date kqtime;
    
    //考勤结果
    private Integer  state;
  //考勤结果_字符串
    private String state_str;
    
    private  String jbyy;
    //部门名称
    private String departmentName;
    //部门id
    private Integer departmentId;
    //公司id
    private Integer companyId;
    //公司名称
    private String companyName;
    
    

    private Float bykqts;

    private Float ygyx;

    private Float ygrx;

    private Date createtime;

    private Date modifytime;

    private Integer deleteby;

    private Integer createby;

    private Integer yl1;
//星期
    private String yl2;

    private Float yl3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPollid() {
        return pollid;
    }

    public void setPollid(Integer pollid) {
        this.pollid = pollid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getKqdate() {
        return kqdate;
    }

    public void setKqdate(Date kqdate) {
        this.kqdate = kqdate;
    }

    public Float getQqsc() {
        return qqsc;
    }

    public void setQqsc(Float qqsc) {
        this.qqsc = qqsc;
    }

    public String getQqyy() {
        return qqyy;
    }

    public void setQqyy(String qqyy) {
        this.qqyy = qqyy == null ? null : qqyy.trim();
    }

    public Float getJbsc() {
        return jbsc;
    }

    public void setJbsc(Float jbsc) {
        this.jbsc = jbsc;
    }

    public String getJbyy() {
        return jbyy;
    }

    public void setJbyy(String jbyy) {
        this.jbyy = jbyy == null ? null : jbyy.trim();
    }

    public Float getBykqts() {
        return bykqts;
    }

    public void setBykqts(Float bykqts) {
        this.bykqts = bykqts;
    }

    public Float getYgyx() {
        return ygyx;
    }

    public void setYgyx(Float ygyx) {
        this.ygyx = ygyx;
    }

    public Float getYgrx() {
        return ygrx;
    }

    public void setYgrx(Float ygrx) {
        this.ygrx = ygrx;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(Integer deleteby) {
        this.deleteby = deleteby;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Integer getYl1() {
        return yl1;
    }

    public void setYl1(Integer yl1) {
        this.yl1 = yl1;
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2 == null ? null : yl2.trim();
    }

    public Float getYl3() {
        return yl3;
    }

    public void setYl3(Float yl3) {
        this.yl3 = yl3;
    }

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getDktime() {
		return dktime;
	}

	public void setDktime(Date dktime) {
		this.dktime = dktime;
	}

	public Date getKqtime() {
		return kqtime;
	}

	public void setKqtime(Date kqtime) {
		this.kqtime = kqtime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getState_str() {
		return state_str;
	}

	public void setState_str(String state_str) {
		this.state_str = state_str;
	}
}