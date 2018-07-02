package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class TeacherRepositoryTest extends DemoApplicationTests {

    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testSelect() {
        Assert.assertEquals(1, teacherRepository.count());
    }

    @Test
    public void testSelectByLastName() {
        Teacher teacher = teacherRepository.getByLastname("udivitelniy");
        Assert.assertEquals("udivitelniy", teacher.getLastname());
    }

    @Test
    public void testSelectById() {
        Long id = new Long(11);
        Teacher teacher = teacherRepository.getById(id);
        Assert.assertEquals(id, teacher.getId());
    }

    @Test
    public void testAdd(){
        teacherService.addTeacher(new Teacher(new Long(45),"test","search"));
    }

    @Test
    public void testDelete(){
        teacherService.delete(new Long(3));
    }

    @Test
    public void testUpdate(){
        teacherService.editTeacher(new Long(2),"test","edit");
    }
}
