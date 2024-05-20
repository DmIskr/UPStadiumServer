package com.example.komitet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
public class CompetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<StadiumEntity> stadium;

    @Nullable
    @Pattern(regexp = "\\d{2}\\.\\d{2}\\.\\d{4}")
    @Schema(description = "Дата проведения матча")
    private String date;

    @Nullable
    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")
    @Schema(description = "Время проведения матча")
    private String time;

    @Nullable
    @Schema(description = "Первая команда-участник")
    private String team1;

    @Nullable
    @Schema(description = "Вторая команда-участник")
    private String team2;
}