package com.example.project_one_colaboration_team.watches.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WatchesRequestDTO {
    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    @NotNull
    private Integer cost;
}
