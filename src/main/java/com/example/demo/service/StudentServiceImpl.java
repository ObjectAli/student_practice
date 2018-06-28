package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student){
        Student savedStundet = studentRepository.saveAndFlush(student);
        return savedStundet;
    }

    @Override
    public Student getById(long id){
        Student getStudentById = studentRepository.getOne(id);
        return getStudentById;
    }

    @Override
    public Student getByLastName(String lastName){
        return studentRepository.getByLastname(lastName);
    }

    @Override
    public Student editStudent(Student student){
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(long id){
        Student deleteStudent = studentRepository.getOne(id);
        studentRepository.delete(deleteStudent);
    }

    @Override
    public List<Student> getAll(){
        return studentRepository.findAll();
    }



}
