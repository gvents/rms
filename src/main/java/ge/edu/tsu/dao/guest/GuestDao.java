package ge.edu.tsu.dao.guest;

import ge.edu.tsu.entity.guest.ScheduleEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GuestDao {
    public String createRequest(String name, String lastName, String company, String phone,
                                String companyEmail, String userEmail, String comment, String startDate,
                                String endDate, String startTime, String endTime, String weekDays, String classroom) {
        String sql = "{ call createRequest(?,?,?,?,?,?,?,?,?,?,?)}";
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();

        try {
            stringBuilder.append(comment);
            stringBuilder.append(";   ");

            if (startDate != null && endDate != null && startTime != null && endTime != null &&
                    !startDate.equals("") && !endDate.equals("") && !startTime.equals("") && !endTime.equals("") &&
                    classroom != null && !classroom.equals("") && weekDays != null && !weekDays.equals("")) {
                stringBuilder.append("აუდიტორია: ").append(classroom).append(";    ");
                if (startDate.equals(endDate)) {
                    stringBuilder.append("თარიღი: ").append(startDate).append(";   ");
                } else {
                    stringBuilder.append("საწყისი და საბოლოო თარიღი: ").append(startDate).append(" - ").append(endDate).append(";   ");
                }
            } else {
                throw new NullPointerException();
            }

            stringBuilder.append("საწყისი და საბოლოო დრო: ").append(startTime).append(" - ").append(endTime).append(";   კვირის დღეები: ");

            Map<String, String> days = new HashMap<>();
            days.put("0", "ორშაბათი");
            days.put("1", "სამშაბათი");
            days.put("2", "ოთხშაბათი");
            days.put("3", "ხუთშაბათი");
            days.put("4", "პარასკევი");
            days.put("5", "შაბათი");
            days.put("6", "კვირა");

            for (int i = 0; i < weekDays.split(" ").length; i++) {
                stringBuilder.append(days.get(weekDays.split(" ")[i])).append(" ");
            }

            System.out.println(stringBuilder.toString());

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, name);
            cstmt.setString(2, lastName);
            cstmt.setString(3, company);
            cstmt.setNull(4, Types.NULL);
            cstmt.setString(5, companyEmail);
            cstmt.setNull(6, Types.NULL);
            cstmt.setString(7, phone);
            cstmt.setString(8, userEmail);
            cstmt.setString(9, stringBuilder.toString());
            cstmt.setNull(10, Types.NULL);
            cstmt.setString(11, "pending");

            cstmt.execute();
            cstmt.close();

            conn.close();

            result = "მოთხოვნა წარმატებით გაიგზავნა!";
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            result = "ველები ცარიელია!";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            result = "დაფიქსირდა შეცდომა!";
        }

        return result;
    }

    public List<ScheduleEntity> getScheduleByClass(String id) {
        String sql = "{ call getScheduleForClass(?)}";
        List<ScheduleEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, id);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ScheduleEntity scheduleEntity = new ScheduleEntity();

                scheduleEntity.setIdSchedule(rs.getInt("idSchedule"));
                scheduleEntity.setStartDate(rs.getString("startDate"));
                scheduleEntity.setEndDate(rs.getString("endDate"));
                scheduleEntity.setStartTime(rs.getString("startTime"));
                scheduleEntity.setEndTime(rs.getString("endTime"));
                scheduleEntity.setWeekDay(rs.getString("weekday"));
                scheduleEntity.setClassroomId(rs.getString("classroom_idClassRoom"));
                scheduleEntity.setSubjectId(rs.getString("subjects_idSubjects"));
                scheduleEntity.setTeacherId(rs.getString("teacher_idTeacher"));

                result.add(scheduleEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}
