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
    private int isProjector;
    private int isComputer;
    private int isInternet;

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

    public int getIsProjector() {
        return isProjector;
    }

    public void setIsProjector(int isProjector) {
        this.isProjector = isProjector;
    }

    public int getIsComputer() {
        return isComputer;
    }

    public void setIsComputer(int isComputer) {
        this.isComputer = isComputer;
    }

    public int getIsInternet() {
        return isInternet;
    }

    public void setIsInternet(int isInternet) {
        this.isInternet = isInternet;
    }
}
