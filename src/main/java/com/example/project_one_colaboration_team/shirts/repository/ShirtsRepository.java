package com.example.project_one_colaboration_team.shirts.repository;

import com.example.project_one_colaboration_team.shirts.model.Shirts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtsRepository extends JpaRepository<Shirts, Long> {
}
