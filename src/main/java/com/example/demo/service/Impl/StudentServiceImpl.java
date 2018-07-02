package com.example.demo.service.Impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getById(Long id) {
        Student getStudentById = studentRepository.getOne(id);
        return getStudentById;
    }

    @Override
    public Student getByLastname(String lastname) {
        return studentRepository.getByLastname(lastname);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void editStudent(Long id, String name, String lastname) {
        Student student = studentRepository.getOne(id);
        student.setName(name);
        student.setLastname(lastname);
        studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(Long id) {
        Student deleteStudent = studentRepository.getOne(id);
        studentRepository.delete(deleteStudent);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

}
