package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(Department department);

    void delete(Long id);

    Department getById(Long id);

    Department getByName(String name);

    Department updateDepartment(Department department);

    List<Department> findAll();

}
