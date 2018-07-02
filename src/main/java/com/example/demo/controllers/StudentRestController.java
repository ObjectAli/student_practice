package com.example.demo.controllers;

import com.example.demo.entity.Student;
import com.example.demo.repository.SpecialtyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    SpecialtyRepository specialtyRepository;

    @GetMapping(path = "/findAll")
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentRepository.getById(id);
    }

    @GetMapping(path = "/{lastname}")
    public Student getStudentByLastname(@PathVariable("lastname") String lastname) {
        return studentRepository.getByLastname(lastname);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping(path = "/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public void delStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
    }
}
