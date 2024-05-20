package com.example.komitetserver.controller;


import com.example.komitetserver.entity.StadiumEntity;
import com.example.komitetserver.response.BaseResponse;
import com.example.komitetserver.response.DataResponse;
import com.example.komitetserver.response.ListResponse;
import com.example.komitetserver.service.StadiumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stadium")
@AllArgsConstructor
@Tag(name = "Стадионы", description = "Позволяет работать со стадионами")
public class StadiumController {

    private final StadiumService service;


    @Operation(
            summary = "Вывод всех стадионов",
            description = "Позволяет вывести все стадионы"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<StadiumEntity>(true,"Все стадионы",service.findAll()));
    }
    @Operation(
            summary = "Добавление стадиона",
            description = "Позволяет добавить новый стадион в приложение"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody StadiumEntity stadium) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<StadiumEntity>(true, "Данные о стадионе добавлены", service.save(stadium)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменение данных о стадионе",
            description = "Позволяет изменить уже внесенные данные о стадионе"
    )
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

    @Operation(
            summary = "Удаление стадиона",
            description = "Позволяет удалить стадион указав его id в БД"
    )
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