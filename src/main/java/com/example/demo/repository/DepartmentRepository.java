package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(@Param("name") String name);

}
