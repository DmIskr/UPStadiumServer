package com.example.komitet.controller;

import com.example.komitet.entity.CompetEntity;
import com.example.komitet.response.BaseResponse;
import com.example.komitet.response.DataResponse;
import com.example.komitet.response.ListResponse;

import com.example.komitet.service.CompetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/compet")
@AllArgsConstructor
public class CompetController {

    private final CompetService service;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<CompetEntity>(true,"Все игры",service.findAll()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody CompetEntity compet) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<CompetEntity>(true, "Данные об игре сохранены", service.save(compet)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody CompetEntity compet) {
        try {
            service.update(compet);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Данные об игре обновлены"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Данные об игре удалены"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}
