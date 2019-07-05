package ge.edu.tsu.entity.subject;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 6/14/2019
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaffEntity {
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
