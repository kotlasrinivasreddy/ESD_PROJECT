package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "student_courses", uniqueConstraints= {@UniqueConstraint(columnNames={"id"})})
public class StudentCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student_id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course_id;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grades grade_id;
    @Column(name = "comments", length = 255, nullable = true, unique = false)
    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Students getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Students student_id) {
        this.student_id = student_id;
    }

    public Courses getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Courses course_id) {
        this.course_id = course_id;
    }

    public Grades getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Grades grade_id) {
        this.grade_id = grade_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Student_courses{" +
                "id=" + id +
                ", student_id=" + student_id.getStudent_id() +
                ", course_id=" + course_id.getCourse_id() +
                ", grade_id=" + grade_id.getGrade_id() +
                ", comments='" + comments + '\'' +
                '}';
    }
}
