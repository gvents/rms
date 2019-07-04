package ge.edu.tsu.controller.guest;

import ge.edu.tsu.entity.guest.ScheduleEntity;
import ge.edu.tsu.service.guest.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 7/1/2019
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("guest")
@CrossOrigin
public class GuestController {
    @Autowired
    private GuestService guestService;

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createRequest/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String createRequest(String name, String lastName, String company, String phone, String companyEmail, String userEmail, String comment) {
        return guestService.createRequest(name, lastName, company, phone, companyEmail, userEmail, comment);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getScheduleByClass",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ScheduleEntity> getScheduleByClass(int id) {
        return guestService.getScheduleByClass(id);
    }
}
