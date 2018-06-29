package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "department", catalog = "alinorbobaevdb")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    public Department() {
    }

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

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false)

    private Specialty specialty;

    public Specialty getSpecialty() {
        return specialty;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Faculty> faculties;

    public Set<Faculty> getFaculties() {
        return faculties;
    }
}

