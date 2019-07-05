package ge.edu.tsu.service.guest;

import ge.edu.tsu.dao.guest.GuestDao;
import ge.edu.tsu.entity.guest.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 7/1/2019
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class GuestService {
    @Autowired
    private GuestDao guestDao;

    public String createRequest(String name, String lastName, String company, String phone,
                                String companyEmail, String userEmail, String comment,
                                String startDate, String endDate, String startTime, String endTime) {
        return guestDao.createRequest(name, lastName, company, phone, companyEmail, userEmail,
                comment, startDate, endDate, startTime, endTime);
    }

    public List<ScheduleEntity> getScheduleByClass(String id) {
        return guestDao.getScheduleByClass(id);
    }
}
