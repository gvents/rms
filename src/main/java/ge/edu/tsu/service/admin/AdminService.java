package ge.edu.tsu.service.admin;

import ge.edu.tsu.dao.admin.AdminDao;
import ge.edu.tsu.entity.admin.RequestEntity;
import ge.edu.tsu.entity.guest.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public String createSchedule(String startDate, String endDate, String startTime,
                               String endTime, String weekday, String classroomId,
                               String subjectId, String teacherId, String company, String subjectName) {
        return adminDao.createSchedule(startDate, endDate, startTime, endTime, weekday, classroomId,
                subjectId, teacherId, company, subjectName);
    }

    public List<ScheduleEntity> getSchedule() {
        return adminDao.getSchedule();
    }

    public List<ScheduleEntity> getScheduledRequests() {
        return adminDao.getScheduledRequests();
    }

    public List<RequestEntity> getAllRequest(String status) {
        return adminDao.getAllRequest(status);
    }

    public void createUser(String username, String password) {
        adminDao.createUser(username, password);
    }

    public int checkUser(String username, String password) {
        return adminDao.checkUser(username, password);
    }

    public void changeStatus(String id, String status) {
        adminDao.changeStatus(id, status);
    }
}
