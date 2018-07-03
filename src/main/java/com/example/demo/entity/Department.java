package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "department", catalog = "alinorbobaevdb")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "department")
    private List<Specialty> specialty;

    public Faculty getFaculties() {
        return faculty;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setFaculties(Faculty faculties) {
        this.faculty = faculties;
    }

    public Department() {
    }

    public Department(Long id, String name){
        this.id = id;
        this.name = name;
    }
}

