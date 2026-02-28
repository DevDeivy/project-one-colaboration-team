package com.example.project_one_colaboration_team.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDTO {

    private UserResponseDTO userResponseDTO;
    private String token;
}
