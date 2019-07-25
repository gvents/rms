package ge.edu.tsu.service.guest;

import ge.edu.tsu.dao.guest.GuestDao;
import ge.edu.tsu.entity.guest.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestDao guestDao;

    public String createRequest(String name, String lastName, String company, String phone,
                                String companyEmail, String userEmail, String comment, String startDate,
                                String endDate, String startTime, String endTime, String weekDays, String classroom) {
        return guestDao.createRequest(name, lastName, company, phone, companyEmail, userEmail,
                comment, startDate, endDate, startTime, endTime, weekDays, classroom);
    }

    public List<ScheduleEntity> getScheduleByClass(String id) {
        return guestDao.getScheduleByClass(id);
    }
}
