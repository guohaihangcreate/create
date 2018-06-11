package create.model.hrm;

import java.util.Date;

public class AttendanceClassTimes {
	
	private Integer id;
	
    private Integer classId;

    private Date planCheckTime;

    private String checkType;

    private Date restBeginTime;

    private Date restEndTime;

    private Integer permitLateMinutes;

    private Integer workTimeMinutes;

    private Integer absenteeismLateMinutes;

    private Integer lateMinutesSeriousLageMinutes;

    private String className;

    private String type;

    private String classesList;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Date getPlanCheckTime() {
        return planCheckTime;
    }

    public void setPlanCheckTime(Date planCheckTime) {
        this.planCheckTime = planCheckTime;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public Date getRestBeginTime() {
        return restBeginTime;
    }

    public void setRestBeginTime(Date restBeginTime) {
        this.restBeginTime = restBeginTime;
    }

    public Date getRestEndTime() {
        return restEndTime;
    }

    public void setRestEndTime(Date restEndTime) {
        this.restEndTime = restEndTime;
    }

    public Integer getPermitLateMinutes() {
        return permitLateMinutes;
    }

    public void setPermitLateMinutes(Integer permitLateMinutes) {
        this.permitLateMinutes = permitLateMinutes;
    }

    public Integer getWorkTimeMinutes() {
        return workTimeMinutes;
    }

    public void setWorkTimeMinutes(Integer workTimeMinutes) {
        this.workTimeMinutes = workTimeMinutes;
    }

    public Integer getAbsenteeismLateMinutes() {
        return absenteeismLateMinutes;
    }

    public void setAbsenteeismLateMinutes(Integer absenteeismLateMinutes) {
        this.absenteeismLateMinutes = absenteeismLateMinutes;
    }

    public Integer getLateMinutesSeriousLageMinutes() {
        return lateMinutesSeriousLageMinutes;
    }

    public void setLateMinutesSeriousLageMinutes(Integer lateMinutesSeriousLageMinutes) {
        this.lateMinutesSeriousLageMinutes = lateMinutesSeriousLageMinutes;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getClassesList() {
        return classesList;
    }

    public void setClassesList(String classesList) {
        this.classesList = classesList == null ? null : classesList.trim();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}