package com.example.project_one_colaboration_team.shoes.mapper;

import com.example.project_one_colaboration_team.shoes.dto.ShoesDto;
import com.example.project_one_colaboration_team.shoes.model.Shoes;

public class ShoesMapper {

    public static ShoesDto toDto(Shoes shoes) {
        return ShoesDto.builder()
                .id(shoes.getId())
                .category(shoes.getCategory())
                .brand(shoes.getBrand())
                .price(shoes.getPrice())
                .size(shoes.getSize())
                .build();
    }

    public static Shoes toEntity(ShoesDto dto) {
        Shoes shoes = new Shoes();
        shoes.setId(dto.getId());
        shoes.setCategory(dto.getCategory());
        shoes.setBrand(dto.getBrand());
        shoes.setPrice(dto.getPrice());
        shoes.setSize(dto.getSize());
        return shoes;
    }
}