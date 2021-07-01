package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "specialization", uniqueConstraints= {@UniqueConstraint(columnNames={"specialization_id"})})
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id", nullable = false, unique = true)
    private int specialization_id;
    @Column(name = "code", length = 20, nullable = false, unique = true)
    private String code;
    @Column(name = "name", length = 255, nullable = false, unique = false)
    private String name;
    @Column(name = "description", length = 255, nullable = true, unique = false)
    private String description;
    @Column(name = "year", nullable = false, unique = false)
    private int year;
    @Column(name = "credits_required", nullable = false, unique = false)
    private int credits_required;

    public int getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(int specialization_id) {
        this.specialization_id = specialization_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getCredits_required() {
        return credits_required;
    }

    public void setCredits_required(int credits_required) {
        this.credits_required = credits_required;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "specialization_id=" + specialization_id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", credits_required=" + credits_required +
                '}';
    }
}
