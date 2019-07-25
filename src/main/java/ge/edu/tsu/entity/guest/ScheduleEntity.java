package ge.edu.tsu.entity.guest;

import java.util.HashMap;
import java.util.Map;

public class ScheduleEntity {
    private int idSchedule;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String weekDay;
    private String classroomId;
    private String classroom;
    private String subjectId;
    private String subject;
    private String teacherId;
    private String teacherName;
    private String teacherLastName;
    private String company;
    private String subjectName;
    private Map<String, String> days = new HashMap<>();

    public ScheduleEntity() {
        days.put("0", "ორშაბათი");
        days.put("1", "სამშაბათი");
        days.put("2", "ოთხშაბათი");
        days.put("3", "ხუთშაბათი");
        days.put("4", "პარასკევი");
        days.put("5", "შაბათი");
        days.put("6", "კვირა");
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWeekDay() {
        return weekDay != null ? toWeekDays(weekDay) : "";
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String toWeekDays(String key) {
        return days.get(key);
    }
}
