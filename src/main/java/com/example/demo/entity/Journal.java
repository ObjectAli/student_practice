package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "journal", catalog = "alinorbobaevdb")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date date;

    @Column
    private String subject;

    @Column
    private boolean presence;

    @Column
    private Integer grade;
//
//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "journal")
//    private Student student;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public boolean getPresence() {
        return presence;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public Journal(){}

    public Journal(Long id, Date date, boolean presence, String subject, Integer grade){
        this.id = id;
        this.date = date;
        this.presence = presence;
        this.subject = subject;
        this.grade = grade;

    }
}
