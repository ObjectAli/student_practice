package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class TeacherRepositoryTest extends DemoApplicationTests {

    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository studentRepository;

    @Test
    public void testSelect(){
        Assert.assertEquals(1,studentRepository.count());
    }

    @Test
    public void testSelectByLastName(){
        Teacher teacher = studentRepository.getByLastname("udivitelniy");
        Assert.assertEquals("udivitelniy",teacher.getLastname());
    }

    @Test
    public void testSelectById(){
        Long id = new Long(11);
        Teacher teacher = studentRepository.getById(id);
        Assert.assertEquals(id, teacher.getId());

    }
}
