package com.example.komitetserver.repository;

import com.example.komitetserver.entity.StadiumEntity;
import org.springframework.data.repository.CrudRepository;

public interface StadiumRepo extends CrudRepository<StadiumEntity, Long> {
}