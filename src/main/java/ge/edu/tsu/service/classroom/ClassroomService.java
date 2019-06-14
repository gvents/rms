package ge.edu.tsu.service.classroom;

import ge.edu.tsu.dao.classroom.ClassroomDao;
import ge.edu.tsu.entity.classroom.ClassroomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/20/2019
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ClassroomService {
    @Autowired
    private ClassroomDao classroomDao;

    public void createClassroom(String number, int capacity, int isProjector, int isComputer, int isInternet) {
        classroomDao.createClassroom(number, capacity, isProjector, isComputer, isInternet);
    }

    public void deleteClassroom(int classroomId) {
        classroomDao.deleteClassroom(classroomId);
    }

    public List<ClassroomEntity> getAllClassroomFilter() {
        return classroomDao.getAllClassroomFilter();
    }

    public List<ClassroomEntity> getAllClassroom(String capRange, String isComp, String isNet, String isProj) {
        return classroomDao.getAllClassroom(capRange, isComp, isNet, isProj);
    }

    public List<ClassroomEntity> getAllClassRoomFilterCap(int capacity) {
        return classroomDao.getAllClassRoomFilterCap(capacity);
    }

    public List<ClassroomEntity> getAllClassRoomFilterComp(int isComputer) {
        return classroomDao.getAllClassRoomFilterComp(isComputer);
    }

    public List<ClassroomEntity> getAllClassRoomFilterInt(int isInternet) {
        return classroomDao.getAllClassRoomFilterInt(isInternet);
    }

    public List<ClassroomEntity> getAllClassRoomFilterPro(int isProjector) {
        return classroomDao.getAllClassRoomFilterPro(isProjector);
    }

    public List<ClassroomEntity> getAllClassRoomSearch(String number) {
        return classroomDao.getAllClassRoomSearch(number);
    }

    public void updateClassroom(int id, String number, int capacity, int isProjector, int isComputer, int isInternet) {
        classroomDao.updateClassroom(id, number, capacity, isProjector, isComputer, isInternet);
    }
}
