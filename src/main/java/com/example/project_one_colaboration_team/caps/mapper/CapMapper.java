package com.example.project_one_colaboration_team.caps.mapper;

import com.example.project_one_colaboration_team.caps.dto.CapDto;
import com.example.project_one_colaboration_team.caps.model.Cap;

public class CapMapper {
    public static CapDto toDto(Cap cap){
        return CapDto.builder()
                .id(cap.getId())
                .category(cap.getCategory())
                .brand(cap.getBrand())
                .price(cap.getPrice())
                .color(cap.getColor())
                .build();
    }

    public static Cap toEntity(CapDto capDto){
        Cap cap = new Cap();
        cap.setId(capDto.getId());
        cap.setCategory(capDto.getCategory());
        cap.setBrand(capDto.getBrand());
        cap.setPrice(capDto.getPrice());
        cap.setColor(capDto.getColor());
        return cap;
    }
}
