package com.example.komitetserver.service;

import com.example.komitetserver.entity.CompetEntity;
import com.example.komitetserver.repository.CompetRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class CompetService {
    private final CompetRepo repo;

    public List<CompetEntity> findAll() {
        return (List<CompetEntity>) repo.findAll();
    }

    public CompetEntity save (@Valid CompetEntity data) {
        return repo.save(data);
    }

    public void update (@Valid CompetEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

}