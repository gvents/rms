package ge.edu.tsu.service.subject;

import ge.edu.tsu.dao.subject.SubjectDao;
import ge.edu.tsu.entity.subject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/22/2019
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    public void createSubject(String name) {
        subjectDao.createSubject(name);
    }

    public void deleteSubject(int subjectId) {
        subjectDao.deleteSubject(subjectId);
    }

    public List<SubjectEntity> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    public void updateSubject(int id, String name) {
        subjectDao.updateSubject(id, name);
    }

    public void createSubjectDepartment(int subjectId, int departmentId) {
        subjectDao.createSubjectDepartment(subjectId, departmentId);
    }

    public void deleteSubjectDepartment(int subjectId, int departmentId) {
        subjectDao.deleteSubjectDepartment(subjectId, departmentId);
    }

    public List<SubjectDepartmentEntity> getAllSubjectDepartments() {
        return subjectDao.getAllSubjectDepartments();
    }

    public void updateSubjectDepartment(int subjectId, int departmentId) {
        subjectDao.updateSubjectDepartment(subjectId, departmentId);
    }

    public void createSubjectSemester(int subjectId, int semesterId) {
        subjectDao.createSubjectSemester(subjectId, semesterId);
    }

    public void deleteSubjectSemester(int subjectId, int semesterId) {
        subjectDao.deleteSubjectSemester(subjectId, semesterId);
    }

    public List<SubjectSemesterEntity> getAllSubjectsSemesters() {
        return subjectDao.getAllSubjectsSemesters();
    }

    public void updateSubjectSemester(int subjectId, int oldSemesterId, int semesterId) {
        subjectDao.updateSubjectSemester(subjectId, oldSemesterId, semesterId);
    }

    public void createSubjectTeacher(int subjectId, int teacherId) {
        subjectDao.createSubjectTeacher(subjectId, teacherId);
    }

    public void deleteSubjectTeacher(int subjectId, int teacherId) {
        subjectDao.deleteSubjectTeacher(subjectId, teacherId);
    }

    public List<SubjectTeachersEntity> getAllSubjectsTeachers() {
        return subjectDao.getAllSubjectsTeachers();
    }

    public void updateSubjectTeacher(int subjectId, int oldTeacherId, int teacherId) {
        subjectDao.updateSubjectTeacher(subjectId, oldTeacherId, teacherId);
    }

    public void createTeacher(String name, String lastName, int age, int departmentId) {
        subjectDao.createTeacher(name, lastName, age, departmentId);
    }

    public void deleteTeacher(int teacherId) {
        subjectDao.deleteTeacher(teacherId);
    }

    public List<TeacherEntity> getAllTeachers() {
        return subjectDao.getAllTeachers();
    }

    public void updateTeacher(int id, String name, String lastName, int age, int departmentId) {
        subjectDao.updateTeacher(id, name, lastName, age, departmentId);
    }
}
