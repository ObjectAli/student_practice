package com.example.demo.entity;

import javax.persistence.*;

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
    private int attendance; //посещаемость

    @Column
    private int acperformance; //успеваемость

    @ManyToOne
    @JoinColumn(name = "specialty_id")

    private Specialty specialty;

    public Student() {
    }

    public Student(Long id, String name, String lastname, int course, int attendance, int acperformance, Specialty specialty) {
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

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getAcperformance() {
        return acperformance;
    }

    public void setAcperformance(int acperformance) {
        this.acperformance = acperformance;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
