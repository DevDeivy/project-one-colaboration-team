package com.example.project_one_colaboration_team.email_sender.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String emailToSend;
}
