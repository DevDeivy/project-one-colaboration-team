package com.example.project_one_colaboration_team.watches.service;

import com.example.project_one_colaboration_team.watches.mapper.WatchesMapper;
import com.example.project_one_colaboration_team.watches.model.Watches;
import com.example.project_one_colaboration_team.watches.repository.WatchesRepository;
import com.example.project_one_colaboration_team.watches.dto.WatchesRequestDTO;
import com.example.project_one_colaboration_team.watches.dto.WatchesResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchesService {

    private final WatchesRepository watchesRepository;
    private final WatchesMapper watchesMapper;

    public List<WatchesResponseDTO> getWatches(){
        return watchesRepository.findAll()
                .stream().map(watchesMapper::entityToDTO)
                .toList();
    }

    public WatchesResponseDTO createWatch(WatchesRequestDTO watchesRequestDTO){
        if (watchesRepository.existsByModel(watchesRequestDTO.getModel())){
            throw new IllegalArgumentException("watch already exists");
        }

        Watches watches = watchesMapper.dtoToEntity(watchesRequestDTO);
        Watches saveWatches = watchesRepository.save(watches);

        return watchesMapper.entityToDTO(saveWatches);
    }

    public WatchesResponseDTO updateWatch(Long id, WatchesRequestDTO watchesRequestDTO){
        var optionalWatch = watchesRepository.findById(id);
        if (optionalWatch.isEmpty())
            throw new EntityNotFoundException("Watch not found");
        Watches watch = optionalWatch.get();
        watchesMapper.updateEntityFromDTO(watchesRequestDTO, watch);
        Watches updateWatches = watchesRepository.save(watch);
        return watchesMapper.entityToDTO(updateWatches);
    }

    public String deleteWatch(Long id){
        if (!watchesRepository.existsById(id)){
            throw new EntityNotFoundException("Watch not found");
        }
        watchesRepository.deleteById(id);
        return "Watch deleted!";
    }

}
