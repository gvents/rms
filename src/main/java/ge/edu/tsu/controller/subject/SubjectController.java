package ge.edu.tsu.controller.subject;

import ge.edu.tsu.entity.subject.*;
import ge.edu.tsu.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createSubject/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createSubject(String name) {
        subjectService.createSubject(name);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteSubject/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteSubject(int subjectId) {
        subjectService.deleteSubject(subjectId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllSubject/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<SubjectEntity> getAllSubject() {
        return subjectService.getAllSubject();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateSubject/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateSubject(int id, String name) {
        subjectService.updateSubject(id, name);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createSubjectDepartment/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createSubjectDepartment(int subjectId, int departmentId) {
        subjectService.createSubjectDepartment(subjectId, departmentId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteSubjectDepartment/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteSubjectDepartment(int subjectId, int departmentId) {
        subjectService.deleteSubjectDepartment(subjectId, departmentId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllSubjectDepartments/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<SubjectDepartmentEntity> getAllSubjectDepartments() {
        return subjectService.getAllSubjectDepartments();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateSubjectDepartment/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateSubjectDepartment(int subjectId, int departmentId) {
        subjectService.updateSubjectDepartment(subjectId, departmentId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createSubjectSemester/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createSubjectSemester(int subjectId, int semesterId) {
        subjectService.createSubjectSemester(subjectId, semesterId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteSubjectSemester/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteSubjectSemester(int subjectId, int semesterId) {
        subjectService.deleteSubjectSemester(subjectId, semesterId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllSubjectsSemesters/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<SubjectSemesterEntity> getAllSubjectsSemesters() {
        return subjectService.getAllSubjectsSemesters();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateSubjectSemester/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateSubjectSemester(int subjectId, int oldSemesterId, int semesterId) {
        subjectService.updateSubjectSemester(subjectId, oldSemesterId, semesterId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createSubjectTeacher/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createSubjectTeacher(int subjectId, int teacherId) {
        subjectService.createSubjectTeacher(subjectId, teacherId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteSubjectTeacher/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteSubjectTeacher(int subjectId, int teacherId) {
        subjectService.deleteSubjectTeacher(subjectId, teacherId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllSubjectsTeachers/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<SubjectTeachersEntity> getAllSubjectsTeachers() {
        return subjectService.getAllSubjectsTeachers();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateSubjectTeacher/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateSubjectTeacher(int subjectId, int oldTeacherId, int teacherId) {
        subjectService.updateSubjectTeacher(subjectId, oldTeacherId, teacherId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createTeacher/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createTeacher(String name, String lastName, int age, int departmentId) {
        subjectService.createTeacher(name, lastName, age, departmentId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteTeacher/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteTeacher(int teacherId) {
        subjectService.deleteTeacher(teacherId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllTeachers/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<TeacherEntity> getAllTeachers() {
        return subjectService.getAllTeachers();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateTeacher/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateTeacher(int id, String name, String lastName, int age, int departmentId) {
        subjectService.updateTeacher(id, name, lastName, age, departmentId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createStaff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createStaff(String name, String lastName, String phone, String email) {
        subjectService.createStaff(name, lastName, phone, email);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteStaff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteStaff(int staffId) {
        subjectService.deleteStaff(staffId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getStaff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<StaffEntity> getStaff() {
        return subjectService.getStaff();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateStaff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateStaff(int id, String name, String lastName, String phone, String email) {
        subjectService.updateStaff(id, name, lastName, phone, email);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createDayOff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createDayOff(String date) {
        subjectService.createDayOff(date);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteDayOff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteDayOff(int dayOffId) {
        subjectService.deleteDayOff(dayOffId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getDayOff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<DayOffEntity> getDayOff() {
        return subjectService.getDayOff();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateDayOff/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateDayOff(int id, String date) {
        subjectService.updateDayOff(id, date);
    }
}
