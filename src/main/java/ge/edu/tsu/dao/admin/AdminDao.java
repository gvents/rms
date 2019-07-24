package ge.edu.tsu.dao.admin;

import ge.edu.tsu.entity.guest.ScheduleEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 7/9/2019
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AdminDao {
    public String createSchedule(String startDate, String endDate, String startTime,
                                 String endTime, String weekday, String classroomId,
                                 String subjectId, String teacherId, String company, String subjectName) {
        String sql = "{ call createSche(?,?,?,?,?,?,?,?,?,?)}";
        String result = "მოთხოვნა წარმატებით განხორციელდა!";

        try {
            if (startDate != null && !startDate.equals("") &&
                    endDate != null && !endDate.equals("") &&
                    startTime != null && !startTime.equals("") &&
                    endTime != null && !endTime.equals("") &&
                    classroomId != null && !classroomId.equals("") &&
                    weekday != null && !weekday.equals("")) {

                DateFormat originalFormat = new SimpleDateFormat("M/d/yyyy");
                DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date sDate = originalFormat.parse(startDate);
                Date eDate = originalFormat.parse(endDate);

                String formattedStartDate = targetFormat.format(sDate);
                String formattedEndDate = targetFormat.format(eDate);
                System.out.println(formattedStartDate);
                System.out.println(formattedEndDate);

                DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");
                DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

                String formattedStartTime = outputFormat.format(timeFormat.parse(startTime));
                String formattedEndTime = outputFormat.format(timeFormat.parse(endTime));
                System.out.println(outputFormat.format(timeFormat.parse(startTime)));

                for (int i = 0; i < weekday.split(" ").length; i++) {
                    if (checkSchedule(formattedStartDate, formattedEndDate, formattedStartTime,
                            formattedEndTime, weekday.split(" ")[i], classroomId) > 0) {
                        throw new SQLDataException();
                    } else {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                                "root", "");

                        CallableStatement cstmt = conn.prepareCall(sql);

                        cstmt.setString(1, formattedStartDate);
                        cstmt.setString(2, formattedEndDate);
                        cstmt.setString(3, formattedStartTime);
                        cstmt.setString(4, formattedEndTime);
                        cstmt.setString(5, weekday.split(" ")[i]);
                        cstmt.setString(6, classroomId);

                        if (subjectId == null || subjectId.equals("")) {
                            cstmt.setNull(7, Types.NULL);
                        } else {
                            cstmt.setString(7, subjectId);
                        }

                        if (teacherId == null || teacherId.equals("")) {
                            cstmt.setNull(8, Types.NULL);
                        } else {
                            cstmt.setString(8, teacherId);
                        }

                        if (company == null || company.equals("")) {
                            cstmt.setNull(9, Types.NULL);
                        } else {
                            cstmt.setString(9, company);
                        }

                        if (subjectName == null || subjectName.equals("")) {
                            cstmt.setNull(10, Types.NULL);
                        } else {
                            cstmt.setString(10, subjectName);
                        }

                        cstmt.execute();
                        cstmt.close();

                        conn.close();
                    }
                }
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            result = "შეავსეთ ველები!";
        } catch (SQLDataException e) {
            System.err.println(e.getMessage());
            result = "მოცემული დრო დაკავებულია!";
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            result = "დაფიქსირდა ბაზის შეცდომა!";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            result = "დაფიქსირდა შეცდომა!";
        }

        return result;
    }

    private int checkSchedule(String startDate, String endDate, String startTime,
                              String endTime, String weekDay, String classroomId) {
        List<String> result = new ArrayList<>();
        String sql = "{ call checkSchedule(?,?,?,?,?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, startDate);
            cstmt.setString(2, endDate);
            cstmt.setString(3, startTime);
            cstmt.setString(4, endTime);
            cstmt.setString(5, weekDay);
            cstmt.setString(6, classroomId);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                result.add(rs.getString("idSchedule"));
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result.size();
    }

    public List<ScheduleEntity> getSchedule() {
        String sql = "{ call getSchedule()}";
        List<ScheduleEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ScheduleEntity scheduleEntity = new ScheduleEntity();

                scheduleEntity.setIdSchedule(rs.getInt("idSchedule"));
                scheduleEntity.setStartDate(rs.getString("startDate"));
                scheduleEntity.setEndDate(rs.getString("endDate"));
                scheduleEntity.setStartTime(rs.getString("startTime"));
                scheduleEntity.setEndTime(rs.getString("endTime"));
                scheduleEntity.setWeekDay(rs.getString("weekday"));
                scheduleEntity.setClassroomId(rs.getString("idClassRoom"));
                scheduleEntity.setClassroom(rs.getString("number"));
                scheduleEntity.setSubjectId(rs.getString("idSubjects"));
                scheduleEntity.setSubject(rs.getString("subjects.name"));
                scheduleEntity.setTeacherId(rs.getString("idTeacher"));
                scheduleEntity.setTeacherName(rs.getString("teacher.name"));
                scheduleEntity.setTeacherName(rs.getString("lastName"));
                scheduleEntity.setCompany(rs.getString("company_name"));
                scheduleEntity.setSubjectName(rs.getString("subject_name"));

                result.add(scheduleEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void createUser(String username, String password) {
        String sql = "{ call createUser(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, username);
            cstmt.setString(2, toSHA(password));

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public int checkUser(String username, String password) {
        int result = -1;
        String sql = "{ call checkUser(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, username);
            cstmt.setString(2, toSHA(password));

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                result = rs.getInt(1);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    private String toSHA(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] messageDigest = md.digest(password.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        String hashText = no.toString(16);

        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return hashText;
    }
}
