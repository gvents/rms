package ge.edu.tsu.controller.admin;

import ge.edu.tsu.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 7/12/2019
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("admin")
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
}