package ge.edu.tsu.entity.subject;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 4/27/2019
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class SubjectDepartmentEntity {
    private int idSubjects;
    private int idDepartments;

    public int getIdSubjects() {
        return idSubjects;
    }

    public void setIdSubjects(int idSubjects) {
        this.idSubjects = idSubjects;
    }

    public int getIdDepartments() {
        return idDepartments;
    }

    public void setIdDepartments(int idDepartments) {
        this.idDepartments = idDepartments;
    }
}
