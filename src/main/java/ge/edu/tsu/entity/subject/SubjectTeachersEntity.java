package ge.edu.tsu.entity.subject;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 4/27/2019
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class SubjectTeachersEntity {
    private int subjectId;
    private int teacherId;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
