package com.example.project_one_colaboration_team.shoes.dto;

import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoesDto {
    private Long id;
    private ProductCategory category;
    private String brand;
    private double price;
    private int size;
}