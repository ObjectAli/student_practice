package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this  class
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int timestart;

    @Column
    private int timeend;

    @Column
    private String auditoryHall;

    @Column
    private String subject;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "timetable")
    private Set<Teacher> teachers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTimestart() {
        return timestart;
    }

    public int getTimeend() {
        return timeend;
    }

    public String getAuditoryHall() {
        return auditoryHall;
    }

    public String getSubject() {
        return subject;
    }

    public void setTimestart(int timestart) {
        this.timestart = timestart;
    }

    public void setTimeend(int timeend) {
        this.timeend = timeend;
    }

    public void setAuditoryHall(String auditoryHall) {
        this.auditoryHall = auditoryHall;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

}
