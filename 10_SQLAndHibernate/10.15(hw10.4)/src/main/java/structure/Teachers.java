package structure;

import lombok.*;


import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    private int age;


}
