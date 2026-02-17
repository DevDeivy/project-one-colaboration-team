package com.example.project_one_colaboration_team.shirts.service;

import com.example.project_one_colaboration_team.shirts.dto.ShirtsDTO;
import com.example.project_one_colaboration_team.shirts.model.Shirts;
import com.example.project_one_colaboration_team.shirts.repository.ShirtsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShirtsService {

    private final ShirtsRepository shirtsRepository;

    public List<Shirts> getShirts(){
        return shirtsRepository.findAll();
    }

    public Shirts createShirts(@RequestBody ShirtsDTO shirtsDTO) {
        Shirts shirts = new Shirts();
        shirts.setBrand(shirtsDTO.getBrand());
        shirts.setCost(shirtsDTO.getCost());
        shirts.setSize(shirtsDTO.getSize());
        return shirtsRepository.save(shirts);
    }

    public Shirts updateShirts(Long id, ShirtsDTO shirtsDTO){
        var optionalShirt = shirtsRepository.findById(id);
        if(!shirtsRepository.existsById(id)){
            throw new RuntimeException("Shirt not found");
        }
        if (optionalShirt.isEmpty()){
            throw new RuntimeException("Shirt not found");
        }
        Shirts shirts = optionalShirt.get();
        shirts.setSize(shirtsDTO.getSize());
        shirts.setCost(shirtsDTO.getCost());
        shirts.setBrand(shirtsDTO.getBrand());
        return shirtsRepository.save(shirts);
    }

    public String deleteShirts(@PathVariable Long id){
        if(!shirtsRepository.existsById(id)){
            throw new RuntimeException("Shirt not found");
        }
        shirtsRepository.deleteById(id);
        return "Shirt deleted!";
    }
}
