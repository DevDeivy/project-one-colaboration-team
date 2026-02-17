package com.example.project_one_colaboration_team.caps.model;

import com.example.project_one_colaboration_team.domain.Models.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_caps")
public class Cap extends Product {
    private String color;
}
