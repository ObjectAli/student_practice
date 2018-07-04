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
        return teacherService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id) {
        return teacherService.getById(id);
    }

    @GetMapping(path = "/lastname/{lastname}")
    public Teacher getTeacherByLastname(@PathVariable("lastname") String lastname) {
        return teacherService.getByLastName(lastname);
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

    @DeleteMapping(path = "/{id}")
    public void delStudent(@PathVariable("id") Long id) {
        teacherService.delete(id);
    }
}
