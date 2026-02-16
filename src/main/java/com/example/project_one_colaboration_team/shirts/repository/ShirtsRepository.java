package com.example.project_one_colaboration_team.infraestructure.repository;

import com.example.project_one_colaboration_team.domain.models.Shirts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtsRepository extends JpaRepository<Shirts, Long> {
}
