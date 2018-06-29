package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class StudentRepositoryTest extends DemoApplicationTests {

    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSelect(){
        Assert.assertEquals(1,studentRepository.count());
    }

    @Test
    public void testSelectByLastName(){
        Student student = studentRepository.getByLastname("straniy");
        Assert.assertEquals("straniy",student.getLastname());
    }

    @Test
    public void testSelectById(){
        Long id = new Long(21);
        Student student = studentRepository.getById(id);
        Assert.assertEquals(id, student.getId());

    }
}
