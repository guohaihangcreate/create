package create.model.hrm;

import java.util.Date;

public class XinziDetail {
    private Integer id;

    private Integer userid;

    private Float sfxz;

    private Float yfxz;

    private Float bfxz;

    private Float jiabxz;

    private Float qtxz;

    private String qtxzsm;

    private Date createtime;

    private Date modifytime;

    private Integer deleteby;

    private Integer createby;

    private Integer yl1;

    private String yl2;

    private Float yl3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getSfxz() {
        return sfxz;
    }

    public void setSfxz(Float sfxz) {
        this.sfxz = sfxz;
    }

    public Float getYfxz() {
        return yfxz;
    }

    public void setYfxz(Float yfxz) {
        this.yfxz = yfxz;
    }

    public Float getBfxz() {
        return bfxz;
    }

    public void setBfxz(Float bfxz) {
        this.bfxz = bfxz;
    }

    public Float getJiabxz() {
        return jiabxz;
    }

    public void setJiabxz(Float jiabxz) {
        this.jiabxz = jiabxz;
    }

    public Float getQtxz() {
        return qtxz;
    }

    public void setQtxz(Float qtxz) {
        this.qtxz = qtxz;
    }

    public String getQtxzsm() {
        return qtxzsm;
    }

    public void setQtxzsm(String qtxzsm) {
        this.qtxzsm = qtxzsm == null ? null : qtxzsm.trim();
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
}