package ge.edu.tsu.dao.guest;

import ge.edu.tsu.entity.guest.ScheduleEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 7/1/2019
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class GuestDao {
    public String createRequest(String name, String lastName, String company, String phone, String companyEmail, String userEmail, String comment) {
        String sql = "{ call createRequest(?,?,?,?,?,?,?,?,?,?,?)}";
        String result = "";

        try {
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
            cstmt.setString(9, comment);
            cstmt.setNull(10, Types.NULL);
            cstmt.setString(11, "pending");

            cstmt.execute();
            cstmt.close();

            conn.close();

            result = "მოთხოვნა წარმატებით გაიგზავნა!";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            result = "არჩეული დროები არაა თავისუფალი!";
        }

        return result;
    }

    public List<ScheduleEntity> getScheduleByClass(int id) {
        String sql = "{ call getScheduleForClass(?)}";
        List<ScheduleEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, id);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ScheduleEntity scheduleEntity = new ScheduleEntity();

                scheduleEntity.setIdSchedule(rs.getInt("idSchedule"));
                scheduleEntity.setStartDate(rs.getString("startDate"));
                scheduleEntity.setEndDate(rs.getString("endDate"));
                scheduleEntity.setStartTime(rs.getString("startTime"));
                scheduleEntity.setEndTime(rs.getString("endTime"));
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
