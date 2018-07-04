package com.example.demo.service.Impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StatisticsService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Override
    public double averageGrade(Long id){
        double averageGrade = 0.0;
        Student student = studentService.getById(id);
        int num = student.getJournal().get(0).getRecords().size();
        for (int i = 0; i < num; i++) {
            averageGrade += student.getJournal().get(0).getRecords().get(0).getGrade();
        }
        return averageGrade/num;
    }


}
