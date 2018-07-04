package com.example.demo.service.Impl;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getById(Long id) {
        Teacher getTeacherById = teacherRepository.getById(id);
        return getTeacherById;
    }

    @Override
    public Teacher getByLastName(String lastName) {
        Teacher getTeacher = teacherRepository.getByLastname(lastName);
        return getTeacher;
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if(!teacherRepository.exists(Example.of(teacher))){
            return teacherRepository.save(teacher);
        }else {
            throw new RuntimeException("Invalid value!");
        }
    }

    @Override
    public void delete(Long id) {
        Teacher deleteTeacher = teacherRepository.getOne(id);
        teacherRepository.delete(deleteTeacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
