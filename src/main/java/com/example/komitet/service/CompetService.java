package com.example.komitet.service;

import com.example.komitet.entity.CompetEntity;

import com.example.komitet.repository.CompetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CompetService {
    private final CompetRepo repo;

    public List<CompetEntity> findAll() {
        return (List<CompetEntity>) repo.findAll();
    }

    public Optional<CompetEntity> findById(Long id) {
        return repo.findById(id);
    }

    public CompetEntity save (CompetEntity data) {
        return repo.save(data);
    }

    public void update (CompetEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

}
