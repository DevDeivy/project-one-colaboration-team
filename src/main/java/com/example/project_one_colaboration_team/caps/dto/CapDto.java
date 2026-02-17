package com.example.project_one_colaboration_team.caps.dto;

import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CapDto {
    private Long id;
    private ProductCategory category;
    private String brand;
    private double price;
    private String color;
}
