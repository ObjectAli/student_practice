package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "faculty", catalog = "alinorbobaevdb")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private List<Department> department;

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

    public Faculty(){}

    public Faculty(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
