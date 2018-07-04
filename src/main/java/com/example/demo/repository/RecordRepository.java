package com.example.demo.repository;


import com.example.demo.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "record", path = "record")
public interface RecordRepository extends JpaRepository<Record, Long> {
}
