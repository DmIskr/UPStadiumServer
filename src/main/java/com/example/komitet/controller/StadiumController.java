package com.example.komitet.controller;

import com.example.komitet.entity.StadiumEntity;
import com.example.komitet.response.BaseResponse;
import com.example.komitet.response.DataResponse;
import com.example.komitet.response.ListResponse;
import com.example.komitet.service.StadiumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stadium")
@AllArgsConstructor
public class StadiumController {

    private final StadiumService service;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<StadiumEntity>(true,"Все стадионы",service.findAll()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody StadiumEntity stadium) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<StadiumEntity>(true, "Данные о стадионе сохранены", service.save(stadium)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody StadiumEntity stadium) {
        try {
            service.update(stadium);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Данные о стадионе обновлены"));
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
                    new BaseResponse(true, "Данные о стадионе удалены"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}