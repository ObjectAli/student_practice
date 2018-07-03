//package com.example.demo.controllers;
//
//import com.example.demo.entity.Department;
//import com.example.demo.repository.DepartmentRepository;
//import com.example.demo.service.DepartmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/department")
//public class DepartmentController {
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    @Autowired
//    DepartmentService departmentService;
//
//    @GetMapping(path = "/findAll")
//    public Iterable<Department> getAllDepartment() {
//        return departmentService.findAll();
//    }
//
//    @GetMapping(path = "/{id}")
//    public Department getDepartmentById(@PathVariable("id") Long id) {
//        return departmentService.getById(id);
//    }
//
//    @GetMapping(path = "/{name}")
//    public Department getDepartmentByName(@PathVariable("name") String name) {
//        return departmentService.getByName(name);
//    }
//
//    @PostMapping
//    public Department addDepartment(@ModelAttribute Department department) {
//        return departmentService.addDepartment(department);
//    }
//
//    @PostMapping(path = "/{id}")
//    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
//        department.setId(id);
//        return departmentService.updateDepartment(department);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    public void delDepartment(@PathVariable("id") Long id) {
//        departmentService.delete(id);
//    }
//}
