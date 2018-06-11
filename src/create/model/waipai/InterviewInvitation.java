package create.model.waipai;

import java.util.Date;

public class InterviewInvitation {
	
    private Integer id;

    private Date interviewdate;

    private Date invitationdate;

    private Integer customer;
//对接负责人
    private Integer djfzr;
//沟通备注
    private String gtbz;

    private String yl;
//面试官
    private String yl1;

    private Integer yl2;

    private String yl3;
//邀请面试人
    private Integer yl4;

    private Integer jlPid;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInterviewdate() {
        return interviewdate;
    }

    public void setInterviewdate(Date interviewdate) {
        this.interviewdate = interviewdate;
    }

    public Date getInvitationdate() {
        return invitationdate;
    }

    public void setInvitationdate(Date invitationdate) {
        this.invitationdate = invitationdate;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getDjfzr() {
        return djfzr;
    }

    public void setDjfzr(Integer djfzr) {
        this.djfzr = djfzr;
    }

    public String getGtbz() {
        return gtbz;
    }

    public void setGtbz(String gtbz) {
        this.gtbz = gtbz == null ? null : gtbz.trim();
    }

    public String getYl() {
        return yl;
    }

    public void setYl(String yl) {
        this.yl = yl == null ? null : yl.trim();
    }

    public String getYl1() {
        return yl1;
    }

    public void setYl1(String yl1) {
        this.yl1 = yl1 == null ? null : yl1.trim();
    }

    public Integer getYl2() {
        return yl2;
    }

    public void setYl2(Integer yl2) {
        this.yl2 = yl2;
    }

    public String getYl3() {
        return yl3;
    }

    public void setYl3(String yl3) {
        this.yl3 = yl3 == null ? null : yl3.trim();
    }

    public Integer getYl4() {
        return yl4;
    }

    public void setYl4(Integer yl4) {
        this.yl4 = yl4;
    }

    public Integer getJlPid() {
        return jlPid;
    }

    public void setJlPid(Integer jlPid) {
        this.jlPid = jlPid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}