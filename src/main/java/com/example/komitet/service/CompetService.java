package com.example.komitet.service;

import com.example.komitet.entity.CompetEntity;

import com.example.komitet.repository.CompetRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


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

    public void delete (Long id) {
        repo.deleteById(id);
    }

}