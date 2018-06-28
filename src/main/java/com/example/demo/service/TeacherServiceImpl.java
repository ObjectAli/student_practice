package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher addStudent(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.saveAndFlush(teacher);
        return savedTeacher;
    }

    @Override
    public void delete(long id) {
        Teacher deleteTeacher = teacherRepository.getOne(id);
        teacherRepository.delete(deleteTeacher);
    }

    @Override
    public Teacher getById(long id) {
        Teacher getTeacherById = teacherRepository.getOne(id);
        return getTeacherById;
    }

    @Override
    public List<Teacher> getByLastName(String lastName) {
        return teacherRepository.getByLastName(lastName);
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
