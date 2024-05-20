package com.example.komitet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
public class CompetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @JoinColumn(name = "stadium_id")
    @ManyToOne
    private StadiumEntity stadium;
    @NotNull
    @Pattern(regexp = "[1-9]{1,2}[.][1-9]{1,2}[.][1-9]{1,4}")
    private String date;
    @NotNull
    private String team1;
    @NotNull
    private String team2;
}
