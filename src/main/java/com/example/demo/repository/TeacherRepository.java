package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t where t.lastname = :lastname")
    Teacher getByLastname(String lastname);

    Teacher getById(Long id);
}

