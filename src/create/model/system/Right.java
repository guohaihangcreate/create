package create.model.system;

import java.io.Serializable;
import java.util.Date;

public class Right implements Serializable{
	
	private Integer trId;

	private String trMark;
//	=-1表示为权限节点，！=-1为权限详细节点
	private Integer parentTrId;

	private Date genTime;

	private String description;

	private String rightName;

	private Integer createby;
	
	private String belong_right;
	//查询条件
	private String in_ids;
	//权限组关系表关联id，临时字段
	private Integer grrId;

	public String getBelong_right() {
		return belong_right;
	}

	public void setBelong_right(String belong_right) {
		this.belong_right = belong_right;
	}

	public Integer getTrId() {
		return trId;
	}

	public void setTrId(Integer trId) {
		this.trId = trId;
	}

	public String getTrMark() {
		return trMark;
	}

	public void setTrMark(String trMark) {
		this.trMark = trMark == null ? null : trMark.trim();
	}

	public Integer getParentTrId() {
		return parentTrId;
	}

	public void setParentTrId(Integer parentTrId) {
		this.parentTrId = parentTrId;
	}

	public Date getGenTime() {
		return genTime;
	}

	public void setGenTime(Date genTime) {
		this.genTime = genTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName == null ? null : rightName.trim();
	}

	public Integer getCreateby() {
		return createby;
	}

	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

	public String getIn_ids() {
		return in_ids;
	}

	public void setIn_ids(String in_ids) {
		this.in_ids = in_ids;
	}

	public Integer getGrrId() {
		return grrId;
	}

	public void setGrrId(Integer grrId) {
		this.grrId = grrId;
	}
}