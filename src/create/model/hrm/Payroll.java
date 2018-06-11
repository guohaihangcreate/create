package create.model.hrm;

import java.util.Date;

import create.model.crm.CustomerInfo;
import create.model.crm.Zcproject;

public class Payroll {
    private Integer id;

    private Integer userid;

    private Float periodwage;

    private Float wage;

    private Date enterdate;
    
    private String enterdate_str;
    
    private String zzdate_str;

    private Date zzdate;

    private String yl;

    private Float yl1;

    private String yl2;
    
    private User user;
    
    private CustomerInfo customerInfo;
    
    private Zcproject zcproject;
    
    

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

    public Float getPeriodwage() {
        return periodwage;
    }

    public void setPeriodwage(Float periodwage) {
        this.periodwage = periodwage;
    }

    public Float getWage() {
        return wage;
    }

    public void setWage(Float wage) {
        this.wage = wage;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Date getZzdate() {
        return zzdate;
    }

    public void setZzdate(Date zzdate) {
        this.zzdate = zzdate;
    }

    public String getYl() {
        return yl;
    }

    public void setYl(String yl) {
        this.yl = yl == null ? null : yl.trim();
    }

    public Float getYl1() {
        return yl1;
    }

    public void setYl1(Float yl1) {
        this.yl1 = yl1;
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2 == null ? null : yl2.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Zcproject getZcproject() {
		return zcproject;
	}

	public void setZcproject(Zcproject zcproject) {
		this.zcproject = zcproject;
	}

	public String getZzdate_str() {
		return zzdate_str;
	}

	public void setZzdate_str(String zzdate_str) {
		this.zzdate_str = zzdate_str;
	}

	public String getEnterdate_str() {
		return enterdate_str;
	}

	public void setEnterdate_str(String enterdate_str) {
		this.enterdate_str = enterdate_str;
	}
}