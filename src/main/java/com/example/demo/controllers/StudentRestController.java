package com.example.demo.controllers;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path = "/findAll")
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/find/{id}")
    public Student getStudent(@PathVariable("id")Long id){
        return studentRepository.getById(id);
    }
}
