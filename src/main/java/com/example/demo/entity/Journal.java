package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "journal", catalog = "alinorbobaevdb")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "journal")
    private List<Record> records;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Journal(){}

    public Journal(Long id, Student student){
        this.id = id;
        this.setStudent(student);
    }
}
