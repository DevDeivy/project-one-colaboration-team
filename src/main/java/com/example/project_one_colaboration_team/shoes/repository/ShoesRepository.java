package com.example.project_one_colaboration_team.shoes.repository;

import com.example.project_one_colaboration_team.shoes.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {
}
