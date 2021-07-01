package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "domains", uniqueConstraints= {@UniqueConstraint(columnNames={"domain_id"})})
public class Domains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id", nullable = false, unique = true)
    private int domain_id;
    @Column(name = "program", length = 50, nullable = false, unique = false)
    private String program;
    @Column(name = "batch", length = 50, nullable = false, unique = false)
    private String batch;
    @Column(name = "capacity", nullable = false, unique = false)
    private int capacity;
    @Column(name = "qualification", length = 50, nullable = true, unique = false)
    private String qualification;

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Domains{" +
                "domain_id=" + domain_id +
                ", program='" + program + '\'' +
                ", batch='" + batch + '\'' +
                ", capacity=" + capacity +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}

