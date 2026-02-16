package com.example.project_one_colaboration_team.watches.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_watches")
@AllArgsConstructor
public class Watches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "model")
    private String model;

    @Column(nullable = false, name = "brand")
    private String brand;

    @Column(nullable = false, name = "cost")
    private Integer cost;
}
