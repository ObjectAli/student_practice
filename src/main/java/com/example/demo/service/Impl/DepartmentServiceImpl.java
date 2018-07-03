//package com.example.demo.service.Impl;
//
//import com.example.demo.entity.Department;
//import com.example.demo.repository.DepartmentRepository;
//import com.example.demo.service.DepartmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DepartmentServiceImpl implements DepartmentService {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @Override
//    public Department getById(Long id) {
//        Optional<Department> found = departmentRepository.findById(id);
////        Department getDepartmentById = ;
//        return getDepartmentById;
//    }
//
//    @Override
//    public Department getByName(String name) {
//        Department getDepartment = departmentRepository.getByName(name);
//        return  getDepartment;
//    }
//
//    @Override
//    public Department addDepartment(Department department) {
//        return departmentRepository.saveAndFlush(department);
//    }
//
//    @Override
//    public Department updateDepartment(Department department) {
//        if(!departmentRepository.exists(Example.of(department))){
//            return departmentRepository.save(department);
//        }else {
//            throw new RuntimeException("Invalid value!");
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        Department deleteDepartment = departmentRepository.getOne(id);
//        departmentRepository.delete(deleteDepartment);
//    }
//
//    @Override
//    public List<Department> findAll() {
//        return departmentRepository.findAll();
//    }
//
//
//}
