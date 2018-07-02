package com.example.demo.controllers;

import com.example.demo.entity.Specialty;
import com.example.demo.entity.Student;
import com.example.demo.repository.SpecialtyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(path = "/findId/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentRepository.getById(id);
    }

    @GetMapping(path = "/findLastname/{lastname}")
    public Student getStudentByLastname(@PathVariable("lastname") String lastname) {
        return studentRepository.getByLastname(lastname);
    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@ModelAttribute Student student) {
        Specialty newspecialty = new Specialty("rus");
        Specialty specialty = specialtyRepository.saveAndFlush(newspecialty);
        studentService.addStudent(new Student(new Long(9), "new", "student", specialty));
    }

    @PostMapping(path = "/update/{id},{name},{lastname},{specialty}")
    public void updateStudent(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("lastname") String lastname) {
        studentService.editStudent(id, name, lastname);
    }

    @DeleteMapping(path = "/del/{id}")
    public void delStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
    }
}
