package com.example.demo.service;

import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    void delete(Long id);

    Teacher getById(Long id);

    Teacher getByLastName(String name);

    Teacher updateTeacher(Teacher teacher);

    List<Teacher> getAll();
}
