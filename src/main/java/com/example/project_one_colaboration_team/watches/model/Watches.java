package com.example.project_one_colaboration_team.watches.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_watches")
@AllArgsConstructor
public class Watches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "model")
    @NotNull
    private String model;

    @Column(nullable = false, name = "brand")
    @NotNull
    private String brand;

    @Column(nullable = false, name = "cost")
    @NotNull
    private Integer cost;
}
