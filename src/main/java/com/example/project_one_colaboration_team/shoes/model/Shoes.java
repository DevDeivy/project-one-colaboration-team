package com.example.project_one_colaboration_team.shoes.model;

import com.example.project_one_colaboration_team.domain.Models.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "tbl_shoes")
public class Shoes extends Product {
    private int size;
}
