package ge.edu.tsu.controller.admin;

import ge.edu.tsu.entity.admin.RequestEntity;
import ge.edu.tsu.entity.guest.ScheduleEntity;
import ge.edu.tsu.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createSchedule/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String createSchedule(String startDate, String endDate, String startTime,
                        String endTime, String weekday, String classroomId,
                        String subjectId, String teacherId, String company, String subjectName) {
        return adminService.createSchedule(startDate, endDate, startTime, endTime, weekday, classroomId,
                subjectId, teacherId, company, subjectName);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getSchedule/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ScheduleEntity> getSchedule() {
        return adminService.getSchedule();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getScheduledRequests/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ScheduleEntity> getScheduledRequests() {
        return adminService.getScheduledRequests();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllRequest/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<RequestEntity> getAllRequest(String status)  {
        return adminService.getAllRequest(status);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createUser/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createUser(String username, String password) {
        adminService.createUser(username, password);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "checkUser/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    int checkUser(String username, String password) {
        return adminService.checkUser(username, password);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "changeStatus/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void changeStatus(String id, String status) {
        adminService.changeStatus(id, status);
    }
}
