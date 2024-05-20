package com.example.komitet.controller;

import com.example.komitet.entity.CompetEntity;
import com.example.komitet.response.BaseResponse;
import com.example.komitet.response.DataResponse;
import com.example.komitet.response.ListResponse;

import com.example.komitet.service.CompetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/compet")
@AllArgsConstructor
@Tag(name = "Матчи", description = "Позволяет работать с данными о матчах")
public class CompetController {

    private final CompetService service;
    @Operation(
            summary = "Вывод всех матчей",
            description = "Позволяет вывести все матчи внесенные в приложение"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<CompetEntity>(true,"Все игры",service.findAll()));
    }

    @Operation(
            summary = "Добавление матча",
            description = "Позволяет добавить новый матч"
    )
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

    @Operation(
            summary = "Удаление матча",
            description = "Позволяет удалить матч по его id в БД"
    )
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