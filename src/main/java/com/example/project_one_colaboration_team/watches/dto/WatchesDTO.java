package com.example.project_one_colaboration_team.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class WatchesDTO {
    private String model;
    private String brand;
    private Integer cost;
}
