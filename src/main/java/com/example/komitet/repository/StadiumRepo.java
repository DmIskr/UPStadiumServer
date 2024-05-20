package com.example.komitet.repository;

import com.example.komitet.entity.StadiumEntity;
import org.springframework.data.repository.CrudRepository;

public interface StadiumRepo extends CrudRepository<StadiumEntity, Long> {
}