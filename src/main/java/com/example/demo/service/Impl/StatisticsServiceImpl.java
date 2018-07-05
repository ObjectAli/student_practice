package com.example.demo.service.Impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StatisticsService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public double averageGrade(Long id){
        double averageGrade = 0.0;
        Student student = studentService.getById(id);
        int num = student.getJournal().get(0).getRecords().size();
        for (int i = 0; i < num; i++) {
            averageGrade += student.getJournal().get(0).getRecords().get(i).getGrade();
        }
        student.setAcperformance(averageGrade/num);
        studentService.updateStudent(student);
        return (double) averageGrade/num;
    }

    @Override
    public double averagePresence(Long id){
        double averagePresence = 0.0;
        Student student = studentService.getById(id);
        int num = student.getJournal().get(0).getRecords().size();
        for (int i = 0; i < num; i++){
            if (student.getJournal().get(0).getRecords().get(i).getPresence()) {
                averagePresence += 1;
            }
        }
        student.setAttendance(averagePresence/num);
        studentService.updateStudent(student);
        return (double) averagePresence/num;
    }



}
