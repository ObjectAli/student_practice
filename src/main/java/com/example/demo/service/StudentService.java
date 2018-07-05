package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    void delete(Long id);

    Student getById(Long id);

    Student getByLastname(String lastname);

    Student updateStudent(Student student);

    List<Student> findAll();

    Student upName(String newName, Student student);

    Student upLastname(String newLastname, Student student);

}
