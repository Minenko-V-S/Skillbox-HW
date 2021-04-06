package structure;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionPK key;

    @Column(name = "subscription_date")
    private Date subscriptionsDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    protected Courses course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    protected Student student;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return key.equals(that.key) &&
                subscriptionsDate.equals(that.subscriptionsDate) &&
                course.equals(that.course) &&
                student.equals(that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, subscriptionsDate, course, student);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SubscriptionPK implements Serializable {

        @Column(name = "course_id")
        protected int courseId;

        @Column(name = "student_id")
        protected int studentId;

    }
}
