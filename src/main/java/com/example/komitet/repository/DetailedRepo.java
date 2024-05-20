package com.example.komitet.repository;

import com.example.komitet.entity.DetailedEntity;
import org.springframework.data.repository.CrudRepository;

public interface DetailedRepo extends CrudRepository<DetailedEntity, Long> {
}