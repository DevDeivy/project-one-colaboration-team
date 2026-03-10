package com.example.project_one_colaboration_team.email_sender.controller;

import com.example.project_one_colaboration_team.email_sender.dto.EmailDTO;
import com.example.project_one_colaboration_team.email_sender.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailDTO emailResponseDTO){
        emailService.sendEmail(emailResponseDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("email sended to: " + emailResponseDTO.getEmailToSend());
    }
}
