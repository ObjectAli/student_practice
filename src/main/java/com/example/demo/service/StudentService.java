package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    void delete(Long id);
    Student getById(Long id);
    Student getByLastName(String name);
    Student editStudent(Student student);
    List<Student> getAll();

}
