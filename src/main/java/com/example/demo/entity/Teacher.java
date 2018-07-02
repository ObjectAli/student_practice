package com.example.demo.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "teachers", catalog = "alinorbobaevdb")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private String department;

    @Column
    private String post;

    @Column
    private String load;

    @ManyToOne
    @JoinColumn(name = "timetable_id")

    private Timetable timetable;

    public Teacher() {
    }

    public Teacher(Long id, String name, String lastname, String department, String post, String load) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.department = department;
        this.post = post;
        this.load = load;
    }

    public Teacher(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public Timetable getTimetable() {
        return timetable;
    }

}
