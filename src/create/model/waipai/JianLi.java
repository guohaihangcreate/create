package create.model.waipai;

import java.util.Date;

public class JianLi {
	
    private Integer pId;

    private String jianliName;

    private Date createTime;

    private Integer createBy;

    private Integer jishuLx;

    private Integer jianliLy;
    
    private Integer gznx;

    private String jianliPath;

    private String beizhu;
    
    private String name;
    
    private String email;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getJianliName() {
        return jianliName;
    }

    public void setJianliName(String jianliName) {
        this.jianliName = jianliName == null ? null : jianliName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getJishuLx() {
        return jishuLx;
    }

    public void setJishuLx(Integer jishuLx) {
        this.jishuLx = jishuLx;
    }

    public Integer getJianliLy() {
        return jianliLy;
    }

    public void setJianliLy(Integer jianliLy) {
        this.jianliLy = jianliLy;
    }

    public String getJianliPath() {
        return jianliPath;
    }

    public void setJianliPath(String jianliPath) {
        this.jianliPath = jianliPath == null ? null : jianliPath.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

	public Integer getGznx() {
		return gznx;
	}

	public void setGznx(Integer gznx) {
		this.gznx = gznx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}