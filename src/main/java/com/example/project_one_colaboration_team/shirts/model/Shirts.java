package com.example.project_one_colaboration_team.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_shirts")
@NoArgsConstructor
@AllArgsConstructor
public class Shirts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "size")
    private String size;

    @Column(nullable = false, name = "brand")
    private String brand;

    @Column(nullable = false, name = "cost")
    private Integer cost;
}
