package com.example.komitetserver.service;

import com.example.komitetserver.entity.StadiumEntity;
import com.example.komitetserver.repository.StadiumRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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