package ge.edu.tsu.entity.classroom;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/22/2019
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassroomEntity {
    private int idClassroom;
    private String number;
    private int capacity;
    private String isProjector;
    private String isComputer;
    private String isInternet;

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getIsProjector() {
        return isProjector;
    }

    public void setIsProjector(String isProjector) {
        this.isProjector = isProjector;
    }

    public String getIsComputer() {
        return isComputer;
    }

    public void setIsComputer(String isComputer) {
        this.isComputer = isComputer;
    }

    public String getIsInternet() {
        return isInternet;
    }

    public void setIsInternet(String isInternet) {
        this.isInternet = isInternet;
    }
}
