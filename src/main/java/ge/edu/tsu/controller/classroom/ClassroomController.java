package ge.edu.tsu.controller.classroom;

import ge.edu.tsu.entity.classroom.ClassroomEntity;
import ge.edu.tsu.service.classroom.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("classroom")
@CrossOrigin
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "createClassroom/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void createClassroom(String number, int capacity, int isProjector, int isComputer, int isInternet) {
        classroomService.createClassroom(number, capacity, isProjector, isComputer, isInternet);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "deleteClassroom/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void deleteClassroom(int classroomId) {
        classroomService.deleteClassroom(classroomId);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllClassroomFilter/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassroomFilter() {
        return classroomService.getAllClassroomFilter();
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"},
            value = "getAllClassroom/ajax/{capRange}/{isComp}/{isNet}/{isProj}",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassroom(@PathVariable("capRange") String capRange,
                                          @PathVariable("isComp") String isComp,
                                          @PathVariable("isNet") String isNet,
                                          @PathVariable("isProj") String isProj) {
        return classroomService.getAllClassroom(capRange, isComp, isNet, isProj);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllClassRoomFilterCap/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassRoomFilterCap(int capacity) {
        return classroomService.getAllClassRoomFilterCap(capacity);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllClassRoomFilterComp/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassRoomFilterComp(int isComputer) {
        return classroomService.getAllClassRoomFilterComp(isComputer);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllClassRoomFilterInt/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassRoomFilterInt(int isInternet) {
        return classroomService.getAllClassRoomFilterInt(isInternet);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllClassRoomFilterPro/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassRoomFilterPro(int isProjector) {
        return classroomService.getAllClassRoomFilterPro(isProjector);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "getAllClassRoomSearch/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<ClassroomEntity> getAllClassRoomSearch(String number) {
        return classroomService.getAllClassRoomSearch(number);
    }

    @RequestMapping(headers = {"Accept=application/json;charset=UTF-8"}, value = "updateClassroom/ajax",
            produces = "application/json;charset=UTF-8")
    public @ResponseBody
    void updateClassroom(int id, String number, int capacity, int isProjector, int isComputer, int isInternet) {
        classroomService.updateClassroom(id, number, capacity, isProjector, isComputer, isInternet);
    }
}
