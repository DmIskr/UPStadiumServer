package com.example.komitetserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stadiums")
public class StadiumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор")
    private Long id;
    @NotNull
    @Schema(description = "Название стадиона")
    private String stadiumName;
    @NotNull
    @Schema(description = "Адрес стадиона")
    private String address;
    @NotNull
    @Schema(description = "Вместимость стадиона")
    private String capacity;
    @NotNull
    @Schema(description = "Состояние бронирования стадиона")
    private String bron;


    @JoinColumn(name = "detailed_id")
    @ManyToOne
    private DetailedEntity detailed;


    @JoinColumn(name = "match_id")
    @ManyToOne
    private CompetEntity match;
}
