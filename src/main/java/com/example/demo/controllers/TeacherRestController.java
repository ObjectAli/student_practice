package com.example.demo.controllers;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @GetMapping(path = "/findAll")
    public Iterable<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @GetMapping(path = "/findId/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id) {
        return teacherRepository.getById(id);
    }

    @GetMapping(path = "/findLastname/{lastname}")
    public Teacher getTeacherByLastname(@PathVariable("lastname") String lastname) {
        return teacherRepository.getByLastname(lastname);
    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(new Teacher(new Long(9), "new", "teacher"));
    }

    @PostMapping(path = "/update/{id},{name},{lastname}")
    public void updateTeacher(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("lastname") String lastname) {
        teacherService.updateTeacher(id, name, lastname);
    }

    @DeleteMapping(path = "/del/{id}")
    public void delStudent(@PathVariable("id") Long id) {
        teacherService.delete(id);
    }
}
