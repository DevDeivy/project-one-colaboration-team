package com.example.project_one_colaboration_team.shirts.mapper;

import com.example.project_one_colaboration_team.shirts.dto.ShirtsRequestDTO;
import com.example.project_one_colaboration_team.shirts.dto.ShirtsResponseDTO;
import com.example.project_one_colaboration_team.shirts.model.Shirts;
import org.springframework.stereotype.Component;

@Component
public class ShirtsMapper {

    public ShirtsResponseDTO entityToDTO(Shirts shirts){
        if(shirts == null) return  null;
        return ShirtsResponseDTO.builder().
                id(shirts.getId())
                        .brand(shirts.getBrand())
                                .cost(shirts.getCost())
                                    .size(shirts.getSize()).
                build();
    }

    public Shirts dtoToEntity(ShirtsRequestDTO shirtsRequestDTO){
        if(shirtsRequestDTO == null) return null;
        Shirts shirts = new Shirts();
        shirts.setBrand(shirtsRequestDTO.getBrand());
        shirts.setCost(shirtsRequestDTO.getCost());
        shirts.setSize(shirtsRequestDTO.getSize());
        return shirts;
    }

    public void updateEntityFromDTO(ShirtsRequestDTO shirtsRequestDTO, Shirts shirts){
        if (shirts == null || shirtsRequestDTO == null) return;
        shirts.setBrand(shirtsRequestDTO.getBrand());
        shirts.setCost(shirtsRequestDTO.getCost());
        shirts.setSize(shirtsRequestDTO.getSize());
    }
}
