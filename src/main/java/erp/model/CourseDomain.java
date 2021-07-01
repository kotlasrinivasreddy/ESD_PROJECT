package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "course_domain", uniqueConstraints= {@UniqueConstraint(columnNames={"id"})})
public class CourseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course_id;
    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domains domain_id;

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

    public Domains getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Domains domain_id) {
        this.domain_id = domain_id;
    }

    @Override
    public String toString() {
        return "Course_domain{" +
                "id=" + id +
                ", course_id=" + course_id.getCourse_id() +
                ", domain_id=" + domain_id.getDomain_id() +
                '}';
    }
}