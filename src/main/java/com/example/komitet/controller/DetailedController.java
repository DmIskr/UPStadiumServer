package com.example.komitet.controller;

import com.example.komitet.entity.DetailedEntity;
import com.example.komitet.response.BaseResponse;
import com.example.komitet.response.DataResponse;
import com.example.komitet.response.ListResponse;
import com.example.komitet.service.DetailedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/detailed")
@AllArgsConstructor
@Tag(name = "Доп. информация о стадионах", description = "Позволяет работать с доп. информацией о стадионе")
public class DetailedController {

    private final DetailedService service;

    @Operation(
            summary = "Вывод всех стадионов",
            description = "Позволяет вывести все стадионы"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<DetailedEntity>(true,"Все стадионы",service.findAll()));
    }
    @Operation(
            summary = "Добавление доп. информации о стадионе",
            description = "Позволяет добавить доп. информацию о стадионе"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody DetailedEntity detailed) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<DetailedEntity>(true, "Данные о стадионе добавлены", service.save(detailed)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменение доп. информации о стадионе",
            description = "Позволяет изменить уже внесенные данные о стадионе"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody DetailedEntity detailed) {
        try {
            service.update(detailed);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Доп. информация о стадионе обновлена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @Operation(
            summary = "Удаление доп. информации о стадионе",
            description = "Позволяет доп. информацию о стадионе указав ее id в БД"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Доп. информация о стадионе удалена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}