package com.example.project_one_colaboration_team.watches.service;

import com.example.project_one_colaboration_team.watches.model.Watches;
import com.example.project_one_colaboration_team.watches.dto.WatchesDTO;
import com.example.project_one_colaboration_team.watches.repository.WatchesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchesService {

    private final WatchesRepository watchesRepository;

    public List<Watches> getWatches(){
        return watchesRepository.findAll();
    }

    public Watches createWatch(@RequestBody WatchesDTO watchesDTO){
        if (watchesRepository.existsByModel(watchesDTO.getModel())){
            throw new RuntimeException("watch already exists");
        }
        Watches watches = new Watches();
        watches.setBrand(watchesDTO.getBrand());
        watches.setModel(watchesDTO.getModel());
        watches.setCost(watchesDTO.getCost());
        return watchesRepository.save(watches);
    }

    public Watches updateWatch(Long id, WatchesDTO watchesDTO){
        var optionalWatch = watchesRepository.findById(id);
        if (optionalWatch.isEmpty()){
            throw new RuntimeException("Watch not found");

        }
        Watches watch = optionalWatch.get();
        watch.setBrand(watchesDTO.getBrand());
        watch.setModel(watchesDTO.getModel());
        watch.setCost(watchesDTO.getCost());
        return watchesRepository.save(watch);

    }

    public String deleteWatch(Long id){
        if (!watchesRepository.existsById(id)){
            throw new RuntimeException("Watch not found");
        }
        watchesRepository.deleteById(id);
        return "Watch deleted!";
    }

}
