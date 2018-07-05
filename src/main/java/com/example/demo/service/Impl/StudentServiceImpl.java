package com.example.demo.service.Impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getById(Long id) {
        Student getStudentById = studentRepository.getById(id);
        return getStudentById;
    }

    @Override
    public Student getByLastname(String lastname) {
        Student getStudent = studentRepository.getByLastname(lastname);
        return  getStudent;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student updateStudent(Student student) {
        if(!studentRepository.exists(Example.of(student))){
            return studentRepository.save(student);
        }else {
            throw new RuntimeException("Invalid value!");
        }
    }

    @Override
    public void delete(Long id) {
        Student deleteStudent = studentRepository.getOne(id);
        studentRepository.delete(deleteStudent);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student upName(String newName, Student student){
        if(!studentRepository.exists(Example.of(student))){
            student.setName(newName);
            return studentRepository.save(student);
        }else {
            throw new RuntimeException("Invalid value!");
        }
    }

    @Override
    public Student upLastname(String newLastname, Student student){
        if(!studentRepository.exists(Example.of(student))){
            student.setName(newLastname);
            return studentRepository.save(student);
        }else {
            throw new RuntimeException("Invalid value!");
        }
    }

}
