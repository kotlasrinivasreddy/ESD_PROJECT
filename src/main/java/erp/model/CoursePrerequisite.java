package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "course_prerequisite", uniqueConstraints= {@UniqueConstraint(columnNames={"id"})})
public class CoursePrerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course_id;
    @ManyToOne
    @JoinColumn(name = "prerequisite")
    private Courses prerequisite;
    @Column(name = "description", length = 255, nullable = true, unique = false)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Courses getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Courses course_id) {
        this.course_id = course_id;
    }

    public Courses getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Courses prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course_prerequisite{" +
                "id=" + id +
                ", course_id=" + course_id.getCourse_id() +
                ", prerequisite=" + prerequisite.getCourse_id() +
                ", description='" + description + '\'' +
                '}';
    }
}