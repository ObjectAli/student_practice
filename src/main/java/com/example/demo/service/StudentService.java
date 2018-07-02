package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    void delete(Long id);

    Student getById(Long id);

    Student getByLastname(String lastname);

    void editStudent(Long id, String name, String lastname);

    List<Student> getAll();

}
