package com.example.demo.repository;

import com.example.demo.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "specialty", path = "specialty")
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
