package com.example.demo.repository;

import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.spi.LocaleNameProvider;

@RepositoryRestResource(collectionResourceRel = "journal", path = "journal")
public interface JournalRepository extends JpaRepository<Journal, LocaleNameProvider> {
}
