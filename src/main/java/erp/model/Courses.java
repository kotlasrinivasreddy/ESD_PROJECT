package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "courses", uniqueConstraints= {@UniqueConstraint(columnNames={"course_id"})})
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false, unique = true)
    private int course_id;
    @Column(name = "course_code", length = 20, nullable = false, unique = true)
    private String course_code;
    @Column(name = "name", length = 255, nullable = false, unique = false)
    private String name;
    @Column(name = "description", length = 255, nullable = false, unique = false)
    private String description;
    @Column(name = "year", nullable = false, unique = false)
    private int year;
    @Column(name = "term", nullable = false, unique = false)
    private int term;
    @Column(name = "credits", nullable = false, unique = false)
    private int credits;
    @Column(name = "capacity", nullable = false, unique = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Employees faculty; //mapping to employee_id of the employees table

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employees getFaculty() {
        return faculty;
    }

    public void setFaculty(Employees faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id=" + course_id +
                ", course_code='" + course_code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", term=" + term +
                ", credits=" + credits +
                ", capacity=" + capacity +
                ", faculty=" + faculty.getEmployee_id() +
                '}';
    }
}
