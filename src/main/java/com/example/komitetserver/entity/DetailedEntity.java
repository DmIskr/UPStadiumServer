package com.example.komitetserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detailed")
public class DetailedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "detailed", cascade = CascadeType.ALL)
    private List<StadiumEntity> stadium;

    @Schema(description = "Информация о безопасности на стадионе")
    private String safe;
    @Schema(description = "Информация о наличии парковок")
    private String parking;
    @Schema(description = "Информация о доступности стадиона")
    private String dostup;
    @Schema(description = "Информация о наличии мест для инвалидов")
    private String dis_place;
    @Schema(description = "Информация о сувенирных лавках на территории стадиона")
    private String gift_shop;
    @Schema(description = "Информация о возможности аренды спортивного оборудования")
    private String arenda_ob;
    @Schema(description = "Информация о наличии туалетов на территории стадиона")
    private String toilets;
    @Schema(description = "Информация о возможности покупки билетов онлайн")
    private String online_tickets;
    @Schema(description = "Информация о наличии раздевалок")
    private String lockers;

}