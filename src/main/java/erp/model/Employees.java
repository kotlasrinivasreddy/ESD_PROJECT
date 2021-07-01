package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "employees", uniqueConstraints= {@UniqueConstraint(columnNames={"employee_id"})})
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false, unique = true)
    private int employee_id;
    @Column(name = "first_name", length = 255, nullable = false, unique = false)
    private String first_name;
    @Column(name = "last_name", length = 255, nullable = true, unique = false)
    private String last_name;
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;
    @Column(name = "title", length = 255, nullable = true, unique = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department; //mapping to dept_id of the department table

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", department=" + department.getDept_id() +
                '}';
    }
}
