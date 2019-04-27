package ge.edu.tsu.dao.subject;

import ge.edu.tsu.entity.subject.*;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/22/2019
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SubjectDao {

    public void createSubject(String name) {
        String sql = "{ call createSubject(?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, name);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteSubject(int subjectId) {
        String sql = "{ call deleteSubject(?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<SubjectEntity> getAllSubject() {
        String sql = "{ call getAllSubject()}";
        List<SubjectEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                SubjectEntity subjectEntity = new SubjectEntity();

                subjectEntity.setIdSubjects(rs.getInt("idSubjects"));
                subjectEntity.setName(rs.getString("name"));

                result.add(subjectEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void updateSubject(int id, String name) {
        String sql = "{ call updateSubject(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, id);
            cstmt.setString(2, name);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void createSubjectDepartment(int subjectId, int departmentId) {
        String sql = "{ call createSubDep(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, departmentId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteSubjectDepartment(int subjectId, int departmentId) {
        String sql = "{ call deleteSubject(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, departmentId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<SubjectDepartmentEntity> getAllSubjectDepartments() {
        String sql = "{ call getAllSubDep()}";
        List<SubjectDepartmentEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                SubjectDepartmentEntity subjectDepartmentEntity = new SubjectDepartmentEntity();

                subjectDepartmentEntity.setIdSubjects(rs.getInt("Subjects_idSubjects"));
                subjectDepartmentEntity.setIdDepartments(rs.getInt("Department_idDepartment"));

                result.add(subjectDepartmentEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void updateSubjectDepartment(int subjectId, int departmentId) {
        String sql = "{ call updateSubDep(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, departmentId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void createSubjectSemester(int subjectId, int semesterId) {
        String sql = "{ call createSubSem(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, semesterId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteSubjectSemester(int subjectId, int semesterId) {
        String sql = "{ call deleteSubSem(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, semesterId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<SubjectSemesterEntity> getAllSubjectsSemesters() {
        String sql = "{ call getAllSubSem()}";
        List<SubjectSemesterEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                SubjectSemesterEntity subjectSemesterEntity = new SubjectSemesterEntity();

                subjectSemesterEntity.setSubjectId(rs.getInt("Subjects_idSubjects"));
                subjectSemesterEntity.setSubjectSemester(rs.getInt("subjects_has_semester"));

                result.add(subjectSemesterEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void updateSubjectSemester(int subjectId, int oldSemesterId, int semesterId) {
        String sql = "{ call updateSubSem(?,?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, oldSemesterId);
            cstmt.setInt(3, semesterId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void createSubjectTeacher(int subjectId, int teacherId) {
        String sql = "{ call createSubTeach(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, teacherId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteSubjectTeacher(int subjectId, int teacherId) {
        String sql = "{ call deleteSubTeach(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, teacherId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<SubjectTeachersEntity> getAllSubjectsTeachers() {
        String sql = "{ call getAllSubTeach()}";
        List<SubjectTeachersEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                SubjectTeachersEntity subjectTeachersEntity = new SubjectTeachersEntity();

                subjectTeachersEntity.setTeacherId(rs.getInt("Teacher_idTeacher"));
                subjectTeachersEntity.setSubjectId(rs.getInt("Subjects_idSubjects"));

                result.add(subjectTeachersEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void updateSubjectTeacher(int subjectId, int oldTeacherId, int teacherId) {
        String sql = "{ call updateSubTech(?,?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, subjectId);
            cstmt.setInt(2, oldTeacherId);
            cstmt.setInt(3, teacherId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void createTeacher(String name, String lastName, int age, int departmentId) {
        String sql = "{ call createTeacher(?,?,?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, name);
            cstmt.setString(2, lastName);
            cstmt.setInt(3, age);
            cstmt.setInt(4, departmentId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteTeacher(int teacherId) {
        String sql = "{ call deleteTeacher(?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, teacherId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<TeacherEntity> getAllTeachers() {
        String sql = "{ call getAllTeacher()}";
        List<TeacherEntity> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                TeacherEntity teacherEntity = new TeacherEntity();

                teacherEntity.setId(rs.getInt("idTeacher"));
                teacherEntity.setName(rs.getString("name"));
                teacherEntity.setLastName(rs.getString("lastName"));
                teacherEntity.setAge(rs.getInt("age"));
                teacherEntity.setDepartmentId(rs.getInt("department_idDepartment"));

                result.add(teacherEntity);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public void updateTeacher(int id, String name, String lastName, int age, int departmentId) {
        String sql = "{ call updateTeacher(?,?)}";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "");

            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, id);
            cstmt.setString(2, name);
            cstmt.setString(3, lastName);
            cstmt.setInt(4, age);
            cstmt.setInt(5, departmentId);

            cstmt.execute();
            cstmt.close();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
