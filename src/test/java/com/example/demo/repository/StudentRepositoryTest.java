package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class StudentRepositoryTest extends DemoApplicationTests {
//
    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSelect(){
        Assert.assertEquals(1,studentRepository.count());
//        Assert.assertEquals(true,true);
    }

}
