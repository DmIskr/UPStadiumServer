package com.example.komitet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stadium_detailed")
public class DetailedEntity {
    @Column(name = "detailed_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "stadium_id")
    @OneToOne
    private StadiumEntity stadium;

    private String safe;
    private String parking;
    private String dostup;
    private String dis_place;
    private String gift_shop;
    private String arenda_ob;
    private String toilets;
    private String online_tickets;
    private String lockers;
}
