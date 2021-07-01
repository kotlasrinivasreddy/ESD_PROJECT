package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "department", uniqueConstraints= {@UniqueConstraint(columnNames={"dept_id"})})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id", nullable = false, unique = true)
    private int dept_id;
    @Column(name = "dname", length = 20, nullable = false, unique = false)
    private String dname;
    @Column(name = "capacity", nullable = false, unique = false)
    private int capacity;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dname='" + dname + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}