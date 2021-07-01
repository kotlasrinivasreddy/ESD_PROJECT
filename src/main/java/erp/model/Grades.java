package erp.model;

import javax.persistence.*;

@Entity
@Table(name= "grades", uniqueConstraints= {@UniqueConstraint(columnNames={"grade_id"})})
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false, unique = true)
    private int grade_id;
    @Column(name = "letter_grade", length = 20, nullable = true, unique = true)
    private String letter_grade;
    @Column(name = "grade_points", nullable = false, unique = false)
    private double grade_points;
    @Column(name = "comment", length = 255, nullable = true, unique = false)
    private String comment;

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getLetter_grade() {
        return letter_grade;
    }

    public void setLetter_grade(String letter_grade) {
        this.letter_grade = letter_grade;
    }

    public double getGrade_points() {
        return grade_points;
    }

    public void setGrade_points(double grade_points) {
        this.grade_points = grade_points;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "grade_id=" + grade_id +
                ", letter_grade='" + letter_grade + '\'' +
                ", grade_points=" + grade_points +
                ", comment='" + comment + '\'' +
                '}';
    }

}
