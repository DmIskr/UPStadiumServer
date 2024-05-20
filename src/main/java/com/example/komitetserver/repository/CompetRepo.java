package com.example.komitetserver.repository;


import com.example.komitetserver.entity.CompetEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompetRepo extends CrudRepository<CompetEntity, Long> {
}