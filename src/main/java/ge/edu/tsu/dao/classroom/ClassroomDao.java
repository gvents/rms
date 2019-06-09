package ge.edu.tsu.dao.classroom;

import ge.edu.tsu.entity.classroom.ClassroomEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/20/2019
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ClassroomDao {
    public void createClassroom(String number, int capacity, int isProjector, int isComputer, int isInternet) {
        String sql = "{ call createClassRoom(?,?,?,?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, number);
            cstmt.setInt(2, capacity);
            cstmt.setInt(3, isProjector);
            cstmt.setInt(4, isComputer);
            cstmt.setInt(5, isInternet);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteClassroom(int classroomId) {
        String sql = "{ call deleteClassRoom(?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, classroomId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<ClassroomEntity> getAllClassroom() {
        String sql = "{ call getAllClassRoom()}";
        List<ClassroomEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ClassroomEntity classroomEntity = new ClassroomEntity();

                classroomEntity.setIdClassroom(rs.getInt("idClassRoom"));
                classroomEntity.setNumber(rs.getString("number"));
                classroomEntity.setCapacity(rs.getInt("capacity"));
                classroomEntity.setIsProjector(rs.getString("isProjector").equals("1") ? "კი" : "არა");
                classroomEntity.setIsComputer(rs.getString("isComputer").equals("1") ? "კი" : "არა");
                classroomEntity.setIsInternet(rs.getString("isInternet").equals("1") ? "კი" : "არა");

                result.add(classroomEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public List<ClassroomEntity> getAllClassRoomFilterCap(int capacity) {
        String sql = "{ call getAllClassRoomFilterCap(?)}";
        List<ClassroomEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, capacity);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ClassroomEntity classroomEntity = new ClassroomEntity();

                classroomEntity.setIdClassroom(rs.getInt("idClassRoom"));
                classroomEntity.setNumber(rs.getString("number"));
                classroomEntity.setCapacity(rs.getInt("capacity"));
                classroomEntity.setIsProjector(rs.getString("isProjector").equals("1") ? "კი" : "არა");
                classroomEntity.setIsComputer(rs.getString("isComputer").equals("1") ? "კი" : "არა");
                classroomEntity.setIsInternet(rs.getString("isInternet").equals("1") ? "კი" : "არა");

                result.add(classroomEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public List<ClassroomEntity> getAllClassRoomFilterComp(int isComputer) {
        String sql = "{ call getAllClassRoomFilterComp(?)}";
        List<ClassroomEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, isComputer);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ClassroomEntity classroomEntity = new ClassroomEntity();

                classroomEntity.setIdClassroom(rs.getInt("idClassRoom"));
                classroomEntity.setNumber(rs.getString("number"));
                classroomEntity.setCapacity(rs.getInt("capacity"));
                classroomEntity.setIsProjector(rs.getString("isProjector").equals("1") ? "კი" : "არა");
                classroomEntity.setIsComputer(rs.getString("isComputer").equals("1") ? "კი" : "არა");
                classroomEntity.setIsInternet(rs.getString("isInternet").equals("1") ? "კი" : "არა");

                result.add(classroomEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public List<ClassroomEntity> getAllClassRoomFilterInt(int isInternet) {
        String sql = "{ call getAllClassRoomFilterInt(?)}";
        List<ClassroomEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, isInternet);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ClassroomEntity classroomEntity = new ClassroomEntity();

                classroomEntity.setIdClassroom(rs.getInt("idClassRoom"));
                classroomEntity.setNumber(rs.getString("number"));
                classroomEntity.setCapacity(rs.getInt("capacity"));
                classroomEntity.setIsProjector(rs.getString("isProjector").equals("1") ? "კი" : "არა");
                classroomEntity.setIsComputer(rs.getString("isComputer").equals("1") ? "კი" : "არა");
                classroomEntity.setIsInternet(rs.getString("isInternet").equals("1") ? "კი" : "არა");

                result.add(classroomEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public List<ClassroomEntity> getAllClassRoomFilterPro(int isProjector) {
        String sql = "{ call getAllClassRoomFilterPro(?)}";
        List<ClassroomEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, isProjector);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ClassroomEntity classroomEntity = new ClassroomEntity();

                classroomEntity.setIdClassroom(rs.getInt("idClassRoom"));
                classroomEntity.setNumber(rs.getString("number"));
                classroomEntity.setCapacity(rs.getInt("capacity"));
                classroomEntity.setIsProjector(rs.getString("isProjector").equals("1") ? "კი" : "არა");
                classroomEntity.setIsComputer(rs.getString("isComputer").equals("1") ? "კი" : "არა");
                classroomEntity.setIsInternet(rs.getString("isInternet").equals("1") ? "კი" : "არა");

                result.add(classroomEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public List<ClassroomEntity> getAllClassRoomSearch(String number) {
        String sql = "{ call getAllClassRoomSearch(?)}";
        List<ClassroomEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, number);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                ClassroomEntity classroomEntity = new ClassroomEntity();

                classroomEntity.setIdClassroom(rs.getInt("idClassRoom"));
                classroomEntity.setNumber(rs.getString("number"));
                classroomEntity.setCapacity(rs.getInt("capacity"));
                classroomEntity.setIsProjector(rs.getString("isProjector").equals("1") ? "კი" : "არა");
                classroomEntity.setIsComputer(rs.getString("isComputer").equals("1") ? "კი" : "არა");
                classroomEntity.setIsInternet(rs.getString("isInternet").equals("1") ? "კი" : "არა");

                result.add(classroomEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void updateClassroom(int id, String number, int capacity, int isProjector, int isComputer, int isInternet) {
        String sql = "{ call updateclassroom(?,?,?,?,?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, id);
            cstmt.setString(2, number);
            cstmt.setInt(3, capacity);
            cstmt.setInt(4, isProjector);
            cstmt.setInt(5, isComputer);
            cstmt.setInt(6, isInternet);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
