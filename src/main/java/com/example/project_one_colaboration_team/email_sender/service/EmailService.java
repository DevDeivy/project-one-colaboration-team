package com.example.project_one_colaboration_team.email_sender.service;

import com.example.project_one_colaboration_team.email_sender.dto.EmailDTO;
import com.example.project_one_colaboration_team.email_sender.model.Email;
import com.example.project_one_colaboration_team.email_sender.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final MailSender mailSender;
    private final EmailRepository emailRepository;

    public void sendEmail(EmailDTO emailDTO){
        if (emailDTO.getEmailToSend() == null) throw  new IllegalArgumentException("Email can´t be empty");
        SimpleMailMessage message = new SimpleMailMessage();
        String body = "Tu codigo para la recuperacion de contraseña es: ";
        message.setSubject(emailDTO.getTitle());
        message.setFrom("developdeivy@gmail.com");
        message.setTo(emailDTO.getEmailToSend());
        message.setText(body + passwordResetCode(emailDTO.getEmailToSend()) + "tu código expira en 1 minuto");
        mailSender.send(message);
    }

    public String passwordResetCode(String email){
        Email response = new Email();
        response.setEmail(email);
        String code = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));
        response.setCode(code);
        response.setExpirationTime(LocalDateTime.now().plusMinutes(1));
        response.setUsed(false);
        emailRepository.save(response);
        return response.getCode();
    }
}
