package com.example.project_one_colaboration_team.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShirtsDTO {
    private String brand;
    private Integer cost;
    private String size;
}
