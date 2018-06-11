package create.model.waipai;

import java.util.Date;

public class Createoffer {
	//客户ID，发offer的时候用
	private Integer khid;
	
	private Integer id;
	//是否为内部员工 1位内部员工，0位外部员工
	 private Integer internalstaff;

	private Float syqgzbl;

	private Integer syq;
	//身份证号码
	private String idNo;

	private Integer sqgz;
	// 试用期工资不映射数据库
	private Integer syqgz;
	//入职联系人
	private String lianxiren;
	//入职联系人电话
	private String rzlxrtele;

	private Integer rzlxr;

	private String email;

	private Date rzstartDatetime;

	private Date rzendDatetime;

	private Integer gw;
	
	private String gw_str;
	
	private String rzbm_str;

	private Integer rzbm;

	private Integer offerTemplate;
//0为正常状态，1为删除状态
	private Integer isdeleted;

	private Integer deletedby;

	private Date deletetime;

	private Integer createdby;

	private Date createtime;

	private Integer lastmodifiedby;

	private Date lastmodifiedtime;

	private String att1;

	private String att2;

	private String att3;

	private String att4;

	private String att5;
	
	private String id_no;

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSyqgzbl() {
		return syqgzbl;
	}

	public void setSyqgzbl(Float syqgzbl) {
		this.syqgzbl = syqgzbl;
	}

	public Integer getSyq() {
		return syq;
	}

	public void setSyq(Integer syq) {
		this.syq = syq;
	}

	public Integer getSqgz() {
		return sqgz;
	}

	public void setSqgz(Integer sqgz) {
		this.sqgz = sqgz;
	}

	public Integer getRzlxr() {
		return rzlxr;
	}

	public void setRzlxr(Integer rzlxr) {
		this.rzlxr = rzlxr;
	}

	public Date getRzstartDatetime() {
		return rzstartDatetime;
	}

	public void setRzstartDatetime(Date rzstartDatetime) {
		this.rzstartDatetime = rzstartDatetime;
	}

	public Date getRzendDatetime() {
		return rzendDatetime;
	}

	public void setRzendDatetime(Date rzendDatetime) {
		this.rzendDatetime = rzendDatetime;
	}

	public Integer getGw() {
		return gw;
	}

	public void setGw(Integer gw) {
		this.gw = gw;
	}

	public Integer getRzbm() {
		return rzbm;
	}

	public void setRzbm(Integer rzbm) {
		this.rzbm = rzbm;
	}

	public Integer getOfferTemplate() {
		return offerTemplate;
	}

	public void setOfferTemplate(Integer offerTemplate) {
		this.offerTemplate = offerTemplate;
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

	public Integer getSyqgz() {
		return syqgz;
	}

	public void setSyqgz(Integer syqgz) {
		this.syqgz = syqgz;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getRzlxrtele() {
		return rzlxrtele;
	}

	public void setRzlxrtele(String rzlxrtele) {
		this.rzlxrtele = rzlxrtele;
	}

	public String getGw_str() {
		return gw_str;
	}

	public void setGw_str(String gw_str) {
		this.gw_str = gw_str;
	}

	public String getRzbm_str() {
		return rzbm_str;
	}

	public void setRzbm_str(String rzbm_str) {
		this.rzbm_str = rzbm_str;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Integer getInternalstaff() {
		return internalstaff;
	}

	public void setInternalstaff(Integer internalstaff) {
		this.internalstaff = internalstaff;
	}

	public Integer getKhid() {
		return khid;
	}

	public void setKhid(Integer khid) {
		this.khid = khid;
	}
}