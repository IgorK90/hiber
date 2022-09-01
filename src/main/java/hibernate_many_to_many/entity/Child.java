package hibernate_many_to_many.entity;

import jdk.jfr.Name;

import javax.persistence.*;

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String firstName;
    @Column(name = "age")
    private int age;
}
