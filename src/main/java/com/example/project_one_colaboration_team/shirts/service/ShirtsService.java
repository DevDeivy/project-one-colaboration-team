package com.example.project_one_colaboration_team.shirts.service;

import com.example.project_one_colaboration_team.shirts.dto.ShirtsRequestDTO;
import com.example.project_one_colaboration_team.shirts.dto.ShirtsResponseDTO;
import com.example.project_one_colaboration_team.shirts.mapper.ShirtsMapper;
import com.example.project_one_colaboration_team.shirts.model.Shirts;
import com.example.project_one_colaboration_team.shirts.repository.ShirtsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShirtsService {

    private final ShirtsRepository shirtsRepository;
    private final ShirtsMapper shirtsMapper;
    private String[] sizeAll = {"S", "M", "L", "XL", "XXL"};

    public List<ShirtsResponseDTO> getShirts(){
        return shirtsRepository.findAll()
                .stream()
                .map(shirtsMapper::entityToDTO)
                .toList();
    }

    public ShirtsResponseDTO createShirts(ShirtsRequestDTO shirtsRequestDTO) {
        if(shirtsRequestDTO == null) return null;
     // if(!Arrays.asList(sizeAll).contains(shirtsRequestDTO.getSize())) throw new IllegalArgumentException("error this aren´t size");
        Shirts shirts = shirtsMapper.dtoToEntity(shirtsRequestDTO);
        Shirts saved = shirtsRepository.save(shirts);
        return shirtsMapper.entityToDTO(saved);
    }

    public ShirtsResponseDTO updateShirts(Long id, ShirtsRequestDTO shirtsRequestDTO){
        var optionalShirt = shirtsRepository.findById(id);
        if(!shirtsRepository.existsById(id)) throw new EntityNotFoundException("Shirt not found");
        if (optionalShirt.isEmpty()) throw new EntityNotFoundException("Shirt not found");
        Shirts shirts = optionalShirt.get();
        shirtsMapper.updateEntityFromDTO(shirtsRequestDTO, shirts);
        Shirts saved = shirtsRepository.save(shirts);
        return shirtsMapper.entityToDTO(saved);
    }

    public String deleteShirts(Long id){
        if(!shirtsRepository.existsById(id)){
            throw new RuntimeException("Shirt not found");
        }
        shirtsRepository.deleteById(id);
        return "Shirt deleted!";
    }
}
