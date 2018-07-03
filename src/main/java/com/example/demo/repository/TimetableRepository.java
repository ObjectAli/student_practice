package com.example.demo.repository;

import com.example.demo.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (collectionResourceRel = "timetable", path = "timetable")
public interface TimetableRepository extends JpaRepository<Timetable,Long> {
}
