package com.example.project_one_colaboration_team.email_sender.repository;

import com.example.project_one_colaboration_team.email_sender.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
