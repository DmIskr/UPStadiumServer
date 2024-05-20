package com.example.komitet.repository;

import com.example.komitet.entity.CompetEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompetRepo extends CrudRepository<CompetEntity, Long> {
}
