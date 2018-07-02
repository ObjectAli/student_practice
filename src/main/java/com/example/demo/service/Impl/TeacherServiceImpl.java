package com.example.demo.service.Impl;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getById(Long id) {
        Teacher getTeacherById = teacherRepository.getOne(id);
        return getTeacherById;
    }

    @Override
    public Teacher getByLastName(String lastName) {
        return teacherRepository.getByLastname(lastName);
    }


    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void editTeacher(Long id, String name, String lastname) {
        Teacher teacher = teacherRepository.getOne(id);
        teacher.setName(name);
        teacher.setLastname(lastname);
        teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void delete(Long id) {
        Teacher deleteTeacher = teacherRepository.getOne(id);
        teacherRepository.delete(deleteTeacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
