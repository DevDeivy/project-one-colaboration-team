package com.example.project_one_colaboration_team.shoes.service;

import com.example.project_one_colaboration_team.shoes.dto.ShoesDto;
import com.example.project_one_colaboration_team.shoes.mapper.ShoesMapper;
import com.example.project_one_colaboration_team.shoes.model.Shoes;
import com.example.project_one_colaboration_team.shoes.repository.ShoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoesService {

    private final ShoesRepository shoesRepository;

    public ShoesDto save(ShoesDto dto){
        Shoes shoes = ShoesMapper.toEntity(dto);
        Shoes saved = shoesRepository.save(shoes);
        return  ShoesMapper.toDto(saved);
    }

    public List<ShoesDto> findAll(){
        return shoesRepository.findAll()
                .stream()
                .map(ShoesMapper::toDto)
                .toList();
    }

    public ShoesDto update(long id, ShoesDto dto){
        Shoes existShoes = shoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoes not found"));

        existShoes.setBrand(dto.getBrand());
        existShoes.setCategory(dto.getCategory());
        existShoes.setPrice(dto.getPrice());
        existShoes.setSize(dto.getSize());

        Shoes shoes = shoesRepository.save(existShoes);

        return ShoesMapper.toDto(shoes);
    }

    public void delete(Long id){
        shoesRepository.deleteById(id);
    }
}
