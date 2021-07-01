package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "student_output", uniqueConstraints= {@UniqueConstraint(columnNames={"roll_no"})})
public class StudentOutput {

    @Id
    @Column(name = "roll_no", nullable = false, unique = true)
    private String roll_no;

    @Column(name = "name", length = 255, nullable = false, unique = false)
    private String name;
    @Column(name = "course_grade", length = 255, nullable = false, unique = true)
    private String course_grade;
    @Column(name = "total_cgpa", columnDefinition = "Decimal(4,3) default 0.000", nullable = false, unique = false)
    private double cgpa;

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_grade() {
        return course_grade;
    }

    public void setCourse_grade(String course_grade) {
        this.course_grade = course_grade;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public StudentOutput() {

    }

    public StudentOutput(String roll_no, String name, String course_grade, double cgpa) {
        this.roll_no = roll_no;
        this.name = name;
        this.course_grade = course_grade;
        this.cgpa = cgpa;
    }
}
