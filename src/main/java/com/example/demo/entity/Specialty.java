package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "specialty", catalog = "alinorbobaevdb")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")
    private Set<Department> users;

    public Set<Department> getDepartment() {
        return users;
    }

    public void setDepartment(Set<Department> users) {
        this.users = users;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")
    private Set<Student> students;

    public Set<Student> getStudent() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
