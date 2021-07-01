package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "specialization_course", uniqueConstraints= {@UniqueConstraint(columnNames={"id"})})
public class SpecializationCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization_id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialization getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(Specialization specialization_id) {
        this.specialization_id = specialization_id;
    }

    public Courses getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Courses course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Specialization_course{" +
                "id=" + id +
                ", specialization_id=" + specialization_id.getSpecialization_id() +
                ", course_id=" + course_id.getCourse_id() +
                '}';
    }
}
