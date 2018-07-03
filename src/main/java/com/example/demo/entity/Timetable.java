package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this  class
@Table(name = "timetable", catalog = "alinorbobaevdb")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int timestart;

    @Column
    private int timeend;

    @Column
    private String auditoryHall;

    @Column
    private String subject;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "timetable")
    private List<Teacher> teachers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Timetable(){}

    public Timetable(Long id, Integer timestart, Integer  timeend, String auditoryHall, String subject0){
        this.id = id;
        this.timestart = timestart;
        this.timeend = timeend;
        this.auditoryHall = auditoryHall;
        this.subject = subject;
    }
}
