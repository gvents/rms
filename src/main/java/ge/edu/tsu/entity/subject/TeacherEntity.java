package ge.edu.tsu.entity.subject;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 4/27/2019
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class TeacherEntity {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private int departmentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
