package com.example.project_one_colaboration_team.watches.mapper;

import com.example.project_one_colaboration_team.watches.dto.WatchesRequestDTO;
import com.example.project_one_colaboration_team.watches.dto.WatchesResponseDTO;
import com.example.project_one_colaboration_team.watches.model.Watches;
import org.springframework.stereotype.Component;

@Component
public class WatchesMapper {

    public WatchesResponseDTO entityToDTO(Watches watches){
        if(watches == null) return null;
        return WatchesResponseDTO.builder().
                id(watches.getId())
                .model(watches.getModel())
                .brand(watches.getBrand())
                .cost(watches.getCost()).build();
    }

    public Watches dtoToEntity(WatchesRequestDTO watchesRequestDTO){
        if (watchesRequestDTO == null) return null;
        Watches watches = new Watches();
        watches.setBrand(watchesRequestDTO.getBrand());
        watches.setModel(watchesRequestDTO.getModel());
        watches.setCost(watchesRequestDTO.getCost());
        return watches;
    }

    public void updateEntityFromDTO(WatchesRequestDTO watchesRequestDTO, Watches watches){
        if(watchesRequestDTO == null || watches == null) return;
        watches.setBrand(watchesRequestDTO.getBrand());
        watches.setModel(watchesRequestDTO.getModel());
        watches.setCost(watchesRequestDTO.getCost());
    }
}










