package create.model.waipai;

import java.util.Date;

public class InterviewRecord {
	private Integer id;
	// 邀请Id
	private Integer yqid;
	// 客户Id
	private Integer khid;
	// 面试结果
	private Integer msjg;
	// 简历id
	private Integer jiid;

	private String bz;

	private Integer isdeleted;

	private Integer deletedby;

	private Date deletetime;

	private Integer createdby;

	private Date createtime;

	private Integer lastmodifiedby;

	private Date lastmodifiedtime;
	
	private String email;
	//抄送
	private String email_cc;
	//密抄
	private String email_mm;
	// 设置为简历id
	private String att1;

	private String att2;
	//邀请人ID
	private String att3;

	private String att4;

	private String att5;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYqid() {
		return yqid;
	}

	public void setYqid(Integer yqid) {
		this.yqid = yqid;
	}

	public Integer getKhid() {
		return khid;
	}

	public void setKhid(Integer khid) {
		this.khid = khid;
	}

	public Integer getMsjg() {
		return msjg;
	}

	public void setMsjg(Integer msjg) {
		this.msjg = msjg;
	}

	public Integer getJiid() {
		return jiid;
	}

	public void setJiid(Integer jiid) {
		this.jiid = jiid;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	public Integer getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Integer getDeletedby() {
		return deletedby;
	}

	public void setDeletedby(Integer deletedby) {
		this.deletedby = deletedby;
	}

	public Date getDeletetime() {
		return deletetime;
	}

	public void setDeletetime(Date deletetime) {
		this.deletetime = deletetime;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(Integer lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	public Date getLastmodifiedtime() {
		return lastmodifiedtime;
	}

	public void setLastmodifiedtime(Date lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}

	public String getAtt1() {
		return att1;
	}

	public void setAtt1(String att1) {
		this.att1 = att1 == null ? null : att1.trim();
	}

	public String getAtt2() {
		return att2;
	}

	public void setAtt2(String att2) {
		this.att2 = att2 == null ? null : att2.trim();
	}

	public String getAtt3() {
		return att3;
	}

	public void setAtt3(String att3) {
		this.att3 = att3 == null ? null : att3.trim();
	}

	public String getAtt4() {
		return att4;
	}

	public void setAtt4(String att4) {
		this.att4 = att4 == null ? null : att4.trim();
	}

	public String getAtt5() {
		return att5;
	}

	public void setAtt5(String att5) {
		this.att5 = att5 == null ? null : att5.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_cc() {
		return email_cc;
	}

	public void setEmail_cc(String email_cc) {
		this.email_cc = email_cc;
	}

	public String getEmail_mm() {
		return email_mm;
	}

	public void setEmail_mm(String email_mm) {
		this.email_mm = email_mm;
	}


}