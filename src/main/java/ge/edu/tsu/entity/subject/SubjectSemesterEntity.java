package ge.edu.tsu.entity.subject;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 4/27/2019
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class SubjectSemesterEntity {
    private int subjectId;
    private int subjectSemester;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSubjectSemester() {
        return subjectSemester;
    }

    public void setSubjectSemester(int subjectSemester) {
        this.subjectSemester = subjectSemester;
    }
}
