package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "students", catalog = "alinorbobaevdb")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private int course;

    @Column
    private double attendance; //посещаемость

    @Column
    private double acperformance; //успеваемость

    @ManyToOne
    @JoinColumn(name = "specialty")
    private Specialty specialty;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Journal> journal;

    public Student() {
    }

    public Student(Long id, String name, String lastname, int course, double attendance, double acperformance, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.course = course;
        this.attendance = attendance;
        this.acperformance = acperformance;
        this.setSpecialty(specialty);
    }

    public Student(Long id, String name, String lastname, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.specialty = specialty;
    }

    public Student(Long id, String name, String lastname) {
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public double getAcperformance() {
        return acperformance;
    }

    public void setAcperformance(double acperformance) {
        this.acperformance = acperformance;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @JsonIgnore
    public List<Journal> getJournal() {
        return journal;
    }
}
