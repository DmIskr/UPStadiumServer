package com.example.komitet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stadiums")
public class StadiumEntity {
    @Column(name = "stadium_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String stadiumName;
    @NotNull
    private String address;
    @NotNull
    private int capacity;
    @NotNull
    private String bron;
}
