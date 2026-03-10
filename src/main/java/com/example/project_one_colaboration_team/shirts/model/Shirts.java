package com.example.project_one_colaboration_team.shirts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
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
