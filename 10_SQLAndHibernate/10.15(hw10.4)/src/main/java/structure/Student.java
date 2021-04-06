package structure;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@ToString
@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Courses> courses;


    }