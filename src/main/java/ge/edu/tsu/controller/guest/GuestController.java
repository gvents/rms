package ge.edu.tsu.controller.guest;

import ge.edu.tsu.entity.guest.ScheduleEntity;
import ge.edu.tsu.service.guest.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("guest")
@CrossOrigin
public class GuestController {
    @Autowired
    private GuestService guestService;

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createRequest/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String createRequest(String name, String lastName, String company, String phone,
                         String companyEmail, String userEmail, String comment, String startDate,
                         String endDate, String startTime, String endTime, String weekDays, String classroom) {
        return guestService.createRequest(name, lastName, company, phone, companyEmail, userEmail,
                comment, startDate, endDate, startTime, endTime, weekDays, classroom);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getScheduleByClass",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ScheduleEntity> getScheduleByClass(String id) {
        return guestService.getScheduleByClass(id);
    }
}
