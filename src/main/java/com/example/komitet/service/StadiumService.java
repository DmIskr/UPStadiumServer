package com.example.komitet.service;

import com.example.komitet.entity.StadiumEntity;
import com.example.komitet.repository.StadiumRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class StadiumService {
    private final StadiumRepo repo;

    public List<StadiumEntity> findAll() {
        return (List<StadiumEntity>) repo.findAll();
    }

    public StadiumEntity save (StadiumEntity data) {
        return repo.save(data);
    }

    public void update (StadiumEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

}