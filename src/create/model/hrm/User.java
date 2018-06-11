package create.model.hrm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
    private Integer id;

    private String loginid;
    //表示登录状态 1为活跃状态表示已经登录,非1表示未登录
    private Integer status;

    private String username;

    private String password;
    //该字段当作简历ID使用
    private String salt;

    private String email;

    private Integer roleid;
    
    private String roleName;

    private Integer sex;
    
    private String mobile0;
    
    private String mobile1;

    private String telephone;

    private Integer departid;
    
    private String departName;

    private Integer jobid;
    
    private String companyId;
    
    private String companyName;
    
    private String jobName;
    //多餘字段
    private String yl3;
    
    private String idno;
//    客户驻场项目ID
    private Integer zcprojectId;
    
    private String zcPid;
    
    private Integer internalstaff;
    //人事负责人，直接字符形式写名字
    private  String rsfzr;
    
    //新增或者修改人员页面的非内部人员 所在的主场地址
    private Integer customerId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date brithday;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createtime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date modifytime;

    private Integer createby;
    //关联钉钉中人员的id
    private String dingtalkId;

    public String getDingtalkId() {
		return dingtalkId;
	}

	public void setDingtalkId(String dingtalkId) {
		this.dingtalkId = dingtalkId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid == null ? null : loginid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getDepartid() {
        return departid;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getMobile0() {
		return mobile0;
	}

	public void setMobile0(String mobile0) {
		this.mobile0 = mobile0;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getYl3() {
		return yl3;
	}

	public void setYl3(String yl3) {
		this.yl3 = yl3;
	}

	public Integer getInternalstaff() {
		return internalstaff;
	}

	public void setInternalstaff(Integer internalstaff) {
		this.internalstaff = internalstaff;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getRsfzr() {
		return rsfzr;
	}

	public void setRsfzr(String rsfzr) {
		this.rsfzr = rsfzr;
	}

	public Integer getZcprojectId() {
		return zcprojectId;
	}

	public void setZcprojectId(Integer zcprojectId) {
		if(zcPid!=null){
			zcprojectId = Integer.valueOf(zcPid);
		}
		this.zcprojectId = zcprojectId;
	}

	public String getZcPid() {
		return zcPid;
	}

	public void setZcPid(String zcPid) {
		this.zcPid = zcPid;
	}
}