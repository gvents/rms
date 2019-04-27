package ge.edu.tsu.entity.subject;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/22/2019
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubjectEntity {
    private int idSubjects;
    private String name;

    public int getIdSubjects() {
        return idSubjects;
    }

    public void setIdSubjects(int idSubjects) {
        this.idSubjects = idSubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
