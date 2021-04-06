package structure;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@ToString
@Entity
@Data

@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;
    private String description;
    @Column(name = "students_count", nullable = false)
    private Integer studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;



    @ManyToOne(cascade  = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teachers teacher;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "subscriptions",
            joinColumns = {@JoinColumn(name ="course_id",referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName="id")}
    )
    private Set<Student> student;

}
