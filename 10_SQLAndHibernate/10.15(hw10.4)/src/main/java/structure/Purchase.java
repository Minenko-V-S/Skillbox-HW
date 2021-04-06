package structure;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Purchases")
public class Purchase {
    @EmbeddedId
    private PurchaseKey key;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "subscription_date", nullable = false)
    private Date subscriptionDate;

    public Purchase(Student student, Courses course, Integer price, Date subscriptionDate) {
        this.key = new PurchaseKey(student, course);
        this.studentName = student.getName();
        this.courseName = course.getName();
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
    public static class PurchaseKey implements Serializable {
        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(
                foreignKey = @ForeignKey(name = "fk_student"),
                name = "student_id",
                columnDefinition = "int(10) unsigned"
        )
        protected Student student;

        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(
                foreignKey = @ForeignKey(name = "fk_course"),
                name = "course_id",
                columnDefinition = "int(10) unsigned"
        )
        protected Courses course;

    }
}