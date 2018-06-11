package create.model.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Group implements Serializable{
	
    private Integer tgId;

    private String tgMark;

    private String groupName;
    
    private String descrption;

    private Integer parentTgId;

    private Integer createby;

    private Date createtime;
    //存放前线数目，不存入数据库
    private Integer right_num;
    //所属权限
    private List<Right> sysRights;

    public Integer getRight_num() {
		return right_num;
	}

	public void setRight_num(Integer right_num) {
		this.right_num = right_num;
	}

	public Integer getTgId() {
        return tgId;
    }

    public void setTgId(Integer tgId) {
        this.tgId = tgId;
    }

    public String getTgMark() {
        return tgMark;
    }

    public void setTgMark(String tgMark) {
        this.tgMark = tgMark == null ? null : tgMark.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getParentTgId() {
        return parentTgId;
    }

    public void setParentTgId(Integer parentTgId) {
        this.parentTgId = parentTgId;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public List<Right> getSysRights() {
		return sysRights;
	}

	public void setSysRights(List<Right> sysRights) {
		this.sysRights = sysRights;
	}

	
}