package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record", catalog = "alinorbobaevdb")
public class Record {

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

    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Record(){}

    public Record(Long id, Date date, String subject, boolean presence, Integer grade, Journal journal ){
        this.id = id;
        this.date = date;
        this.subject = subject;
        this.presence = presence;
        this.grade = grade;
        this.setJournal(journal);
    }
}
