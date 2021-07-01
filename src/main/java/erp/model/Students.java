package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "students", uniqueConstraints= {@UniqueConstraint(columnNames={"student_id"})})
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false, unique = true)
    private int student_id;
    @Column(name = "roll_no", length = 20, nullable = false, unique = true)
    private String roll_no;
    @Column(name = "first_name", length = 255, nullable = false, unique = false)
    private String first_name;
    @Column(name = "last_name", length = 255, nullable = true, unique = false)
    private String last_name;
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;
    @Column(name = "cgpa", columnDefinition = "Decimal(4,3) default 0.000", nullable = false, unique = false)
    private double cgpa;
    @Column(name = "total_credits", nullable = false, unique = false)
    private int total_credits;
    @Column(name = "graduation_year", nullable = false, unique = false)
    private int graduation_year;
    @ManyToOne
    @JoinColumn(name = "domain")
    private Domains domain;
    @ManyToOne
    @JoinColumn(name = "specialization")
    private Specialization specialization;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(int total_credits) {
        this.total_credits = total_credits;
    }

    public int getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(int graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Domains getDomain() {
        return domain;
    }

    public void setDomain(Domains domain) {
        this.domain = domain;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Students{" +
                "student_id=" + student_id +
                ", roll_no='" + roll_no + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", cgpa=" + cgpa +
                ", total_credits=" + total_credits +
                ", graduation_year=" + graduation_year +
                ", domain=" + domain.getDomain_id() +
                ", specialization=" + specialization.getSpecialization_id() +
                '}';
    }
}
