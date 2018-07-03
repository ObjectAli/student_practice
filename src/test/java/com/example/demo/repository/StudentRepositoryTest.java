package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class StudentRepositoryTest extends DemoApplicationTests {

    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    public void testSelect() {
        Assert.assertEquals(2, studentRepository.count());
    }

    @Test
    public void testSelectByLastName() {
        Student student = studentRepository.getByLastname("tretiy");
        Assert.assertEquals("tretiy", student.getLastname());
    }

    @Test
    public void testSelectById() {
        Long id = new Long(5);
        Student student = studentRepository.getById(id);
        Assert.assertEquals(id, student.getId());
    }

    @Test
    public void testAdd(){
        studentService.addStudent(new Student(new Long(45),"test","search"));
    }

    @Test
    public void testDelete(){
        studentService.delete(new Long(3));
    }

//    @Test
//    public void testUpdate(){
//        studentService.updateStudent();
//    }
}
