package com.example.komitetserver.repository;

import com.example.komitetserver.entity.DetailedEntity;
import org.springframework.data.repository.CrudRepository;

public interface DetailedRepo extends CrudRepository<DetailedEntity, Long> {
}
