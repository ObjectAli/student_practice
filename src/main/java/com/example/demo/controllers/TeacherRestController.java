package com.example.demo.controllers;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id) {
        return teacherRepository.getById(id);
    }

    @GetMapping(path = "/{lastname}")
    public Teacher getTeacherByLastname(@PathVariable("lastname") String lastname) {
        return teacherRepository.getByLastname(lastname);
    }

    @PostMapping
    public Teacher addTeacher(@ModelAttribute Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PostMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping(path = "/del/{id}")
    public void delStudent(@PathVariable("id") Long id) {
        teacherService.delete(id);
    }
}
