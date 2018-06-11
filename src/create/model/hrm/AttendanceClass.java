package create.model.hrm;

public class AttendanceClass {
	//不映射数据库
	private String rest_begintime;
	//不映射数据库
	private String rest_endtime;
	
    private String classid;

    private String classname;

    private String groupid;

    private String yl1;

    private String yl2;

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getYl1() {
        return yl1;
    }

    public void setYl1(String yl1) {
        this.yl1 = yl1 == null ? null : yl1.trim();
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2 == null ? null : yl2.trim();
    }

	public String getRest_begintime() {
		return rest_begintime;
	}

	public void setRest_begintime(String rest_begintime) {
		this.rest_begintime = rest_begintime;
	}

	public String getRest_endtime() {
		return rest_endtime;
	}

	public void setRest_endtime(String rest_endtime) {
		this.rest_endtime = rest_endtime;
	}
}