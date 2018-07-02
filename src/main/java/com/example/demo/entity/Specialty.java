package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "specialty", catalog = "alinorbobaevdb")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")
    private List<Student> students;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")
    private Set<Department> users;

    public void setDepartment(Set<Department> users) {
        this.users = users;
    }

    public Specialty() {
    }

    public Specialty(String name) {
        this.name = name;
    }
}
