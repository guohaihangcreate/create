package create.model.system;

import java.util.Date;
import java.util.List;

public class GroupRightRelation {
	
    private Integer tgrId;

    private Integer tgId;

    private Integer trId;

    private Integer rightType;

    private Date createtime;

    private Integer createby;
    

    public Integer getTgrId() {
        return tgrId;
    }

    public void setTgrId(Integer tgrId) {
        this.tgrId = tgrId;
    }

    public Integer getTgId() {
        return tgId;
    }

    public void setTgId(Integer tgId) {
        this.tgId = tgId;
    }

    public Integer getTrId() {
        return trId;
    }

    public void setTrId(Integer trId) {
        this.trId = trId;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
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

}