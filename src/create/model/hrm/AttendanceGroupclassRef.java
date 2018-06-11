package create.model.hrm;

public class AttendanceGroupclassRef {
	
    private Integer groupclassid;

    private Integer groupid;

    private Integer classid;

    private String yl1;

    private String yl2;

    private String yl3;

    public Integer getGroupclassid() {
        return groupclassid;
    }

    public void setGroupclassid(Integer groupclassid) {
        this.groupclassid = groupclassid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
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

    public String getYl3() {
        return yl3;
    }

    public void setYl3(String yl3) {
        this.yl3 = yl3 == null ? null : yl3.trim();
    }
}