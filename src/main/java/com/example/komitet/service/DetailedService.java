package com.example.komitet.service;

import com.example.komitet.entity.DetailedEntity;

import com.example.komitet.repository.DetailedRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class DetailedService {
    private final DetailedRepo repo;

    public List<DetailedEntity> findAll() {
        return (List<DetailedEntity>) repo.findAll();
    }

    public DetailedEntity save (DetailedEntity data) {
        return repo.save(data);
    }

    public void update (DetailedEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

}