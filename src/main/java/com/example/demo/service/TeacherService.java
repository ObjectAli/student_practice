package com.example.demo.service;

import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addStudent(Teacher teacher);
    void delete(long id);
    Teacher getById(long id);
    List<Teacher> getByLastName(String name);
    Teacher editTeacher(Teacher teacher);
    List<Teacher> getAll();
}
