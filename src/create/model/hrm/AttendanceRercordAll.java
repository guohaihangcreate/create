package create.model.hrm;

import java.util.Date;

public class AttendanceRercordAll {
	
    private Integer id;

    private String groupid;

    private String planid;

    private String workdate;

    private String userid;
    
    private String userName;
    
    private String jobName;
    
    private String departName;

    private String checktype;

    private String sourcetype;

    private String timeresult;

    private String locationresult;

    private String approveid;

    private String procinstid;

    private String basechecktime;

    private String userchecktime;

    private Integer islegal;

    private String classid;

    private String locationmethod;

    private String deviceid;

    private String useraddress;

    private String userlongitude;

    private String userlatitude;

    private String useraccuracy;

    private String userssid;

    private String usermacaddr;

    private String planchecktime;

    private String baseaddress;

    private String baselongitude;

    private String baselatitude;

    private String baseaccuracy;

    private String basessid;

    private String basemacaddr;

    private String gmtcreate;

    private String gmtmodified;

    private String outsideremark;
    
    private String companyID;

    public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid == null ? null : planid.trim();
    }



    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype == null ? null : checktype.trim();
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype == null ? null : sourcetype.trim();
    }

    public String getTimeresult() {
        return timeresult;
    }

    public void setTimeresult(String timeresult) {
        this.timeresult = timeresult == null ? null : timeresult.trim();
    }

    public String getLocationresult() {
        return locationresult;
    }

    public void setLocationresult(String locationresult) {
        this.locationresult = locationresult == null ? null : locationresult.trim();
    }

    public String getApproveid() {
        return approveid;
    }

    public void setApproveid(String approveid) {
        this.approveid = approveid == null ? null : approveid.trim();
    }

    public String getProcinstid() {
        return procinstid;
    }

    public void setProcinstid(String procinstid) {
        this.procinstid = procinstid == null ? null : procinstid.trim();
    }

    

    public Integer getIslegal() {
        return islegal;
    }

    public void setIslegal(Integer islegal) {
        this.islegal = islegal;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getLocationmethod() {
        return locationmethod;
    }

    public void setLocationmethod(String locationmethod) {
        this.locationmethod = locationmethod == null ? null : locationmethod.trim();
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
    }

    public String getUserlongitude() {
        return userlongitude;
    }

    public void setUserlongitude(String userlongitude) {
        this.userlongitude = userlongitude == null ? null : userlongitude.trim();
    }

    public String getUserlatitude() {
        return userlatitude;
    }

    public void setUserlatitude(String userlatitude) {
        this.userlatitude = userlatitude == null ? null : userlatitude.trim();
    }

    public String getUseraccuracy() {
        return useraccuracy;
    }

    public void setUseraccuracy(String useraccuracy) {
        this.useraccuracy = useraccuracy == null ? null : useraccuracy.trim();
    }

    public String getUserssid() {
        return userssid;
    }

    public void setUserssid(String userssid) {
        this.userssid = userssid == null ? null : userssid.trim();
    }

    public String getUsermacaddr() {
        return usermacaddr;
    }

    public void setUsermacaddr(String usermacaddr) {
        this.usermacaddr = usermacaddr == null ? null : usermacaddr.trim();
    }



    public String getBaseaddress() {
        return baseaddress;
    }

    public void setBaseaddress(String baseaddress) {
        this.baseaddress = baseaddress == null ? null : baseaddress.trim();
    }

    public String getBaselongitude() {
        return baselongitude;
    }

    public void setBaselongitude(String baselongitude) {
        this.baselongitude = baselongitude == null ? null : baselongitude.trim();
    }

    public String getBaselatitude() {
        return baselatitude;
    }

    public void setBaselatitude(String baselatitude) {
        this.baselatitude = baselatitude == null ? null : baselatitude.trim();
    }

    public String getBaseaccuracy() {
        return baseaccuracy;
    }

    public void setBaseaccuracy(String baseaccuracy) {
        this.baseaccuracy = baseaccuracy == null ? null : baseaccuracy.trim();
    }

    public String getBasessid() {
        return basessid;
    }

    public void setBasessid(String basessid) {
        this.basessid = basessid == null ? null : basessid.trim();
    }

    public String getBasemacaddr() {
        return basemacaddr;
    }

    public void setBasemacaddr(String basemacaddr) {
        this.basemacaddr = basemacaddr == null ? null : basemacaddr.trim();
    }


    public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getBasechecktime() {
		return basechecktime;
	}

	public void setBasechecktime(String basechecktime) {
		this.basechecktime = basechecktime;
	}

	public String getUserchecktime() {
		return userchecktime;
	}

	public void setUserchecktime(String userchecktime) {
		this.userchecktime = userchecktime;
	}

	public String getPlanchecktime() {
		return planchecktime;
	}

	public void setPlanchecktime(String planchecktime) {
		this.planchecktime = planchecktime;
	}

	public String getGmtcreate() {
		return gmtcreate;
	}

	public void setGmtcreate(String gmtcreate) {
		this.gmtcreate = gmtcreate;
	}

	public String getGmtmodified() {
		return gmtmodified;
	}

	public void setGmtmodified(String gmtmodified) {
		this.gmtmodified = gmtmodified;
	}

	public String getOutsideremark() {
        return outsideremark;
    }

    public void setOutsideremark(String outsideremark) {
        this.outsideremark = outsideremark == null ? null : outsideremark.trim();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
}