package create.model.hrm;

public class AttendanceAlasssetting {
    private Integer id;

    private String classId;

    private String classSettingId;

    private Integer absenteeismLateMinutes;

    private String isOffDutyFreeCheck;

    private Integer permitLateMinutes;

    private Integer seriousLateMinutes;

    private Integer workTimeMinutes;

    private String yl1;

    private String yl2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getClassSettingId() {
        return classSettingId;
    }

    public void setClassSettingId(String classSettingId) {
        this.classSettingId = classSettingId == null ? null : classSettingId.trim();
    }

    public Integer getAbsenteeismLateMinutes() {
        return absenteeismLateMinutes;
    }

    public void setAbsenteeismLateMinutes(Integer absenteeismLateMinutes) {
        this.absenteeismLateMinutes = absenteeismLateMinutes;
    }

    public String getIsOffDutyFreeCheck() {
        return isOffDutyFreeCheck;
    }

    public void setIsOffDutyFreeCheck(String isOffDutyFreeCheck) {
        this.isOffDutyFreeCheck = isOffDutyFreeCheck == null ? null : isOffDutyFreeCheck.trim();
    }

    public Integer getPermitLateMinutes() {
        return permitLateMinutes;
    }

    public void setPermitLateMinutes(Integer permitLateMinutes) {
        this.permitLateMinutes = permitLateMinutes;
    }

    public Integer getSeriousLateMinutes() {
        return seriousLateMinutes;
    }

    public void setSeriousLateMinutes(Integer seriousLateMinutes) {
        this.seriousLateMinutes = seriousLateMinutes;
    }

    public Integer getWorkTimeMinutes() {
        return workTimeMinutes;
    }

    public void setWorkTimeMinutes(Integer workTimeMinutes) {
        this.workTimeMinutes = workTimeMinutes;
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
}