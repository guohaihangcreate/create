package create.model.system;

import java.util.Date;

public class Dictionarydata {

	private Integer id;

	private Integer dictValue;

	private String dictdataName;

	private String dictdataValue;
	// 删除标志 1表示删除，0表示正在使用
	private Integer isfixed;

	private String deletedby;

	private Date deletetime;

	private String createdby;

	private Date createtime;

	private String lastmodifiedby;

	private Date lastmodifiedtime;

	private String att1;

	private String att2;

	private String att3;

	private String att4;

	private String att5;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDictValue() {
		return dictValue;
	}

	public void setDictValue(Integer dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictdataName() {
		return dictdataName;
	}

	public void setDictdataName(String dictdataName) {
		this.dictdataName = dictdataName == null ? null : dictdataName.trim();
	}

	public String getDictdataValue() {
		return dictdataValue;
	}

	public void setDictdataValue(String dictdataValue) {
		this.dictdataValue = dictdataValue == null ? null : dictdataValue
				.trim();
	}

	public Integer getIsfixed() {
		return isfixed;
	}

	public void setIsfixed(Integer isfixed) {
		this.isfixed = isfixed;
	}

	public String getDeletedby() {
		return deletedby;
	}

	public void setDeletedby(String deletedby) {
		this.deletedby = deletedby == null ? null : deletedby.trim();
	}

	public Date getDeletetime() {
		return deletetime;
	}

	public void setDeletetime(Date deletetime) {
		this.deletetime = deletetime;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby == null ? null : createdby.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(String lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby == null ? null : lastmodifiedby
				.trim();
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
}