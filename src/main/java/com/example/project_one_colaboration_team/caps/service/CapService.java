package com.example.project_one_colaboration_team.caps.service;

import com.example.project_one_colaboration_team.caps.dto.CapDto;
import com.example.project_one_colaboration_team.caps.mapper.CapMapper;
import com.example.project_one_colaboration_team.caps.model.Cap;
import com.example.project_one_colaboration_team.caps.repository.CapRepository;
import com.example.project_one_colaboration_team.shoes.mapper.ShoesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CapService {

    private static CapRepository capRepository;

    public CapDto save(CapDto dto){
        Cap cap = CapMapper.toEntity(dto);
        Cap saved = capRepository.save(cap);
        return CapMapper.toDto(saved);
    }

    public List<CapDto> getAll(){
        return capRepository.findAll()
                .stream()
                .map(CapMapper::toDto)
                .toList();
    }

    public CapDto findById(long id){
        Cap cap = capRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Cap not found") );
        return CapMapper.toDto(cap);
    }

    public void deleteDyId(Long id){
        capRepository.deleteById(id);
    }
}
