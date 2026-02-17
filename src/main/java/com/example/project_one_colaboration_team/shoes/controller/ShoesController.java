package com.example.project_one_colaboration_team.shoes.controller;

import com.example.project_one_colaboration_team.shoes.dto.ShoesDto;
import com.example.project_one_colaboration_team.shoes.service.ShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/shoes")
@RequiredArgsConstructor
public class ShoesController {

    private final ShoesService shoesService;

    @PostMapping
    public ResponseEntity<ShoesDto> create(@RequestBody ShoesDto dto){
        return ResponseEntity.ok(shoesService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ShoesDto>> getAll(){
        return ResponseEntity.ok(shoesService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoesDto> update(@PathVariable long id, @RequestBody ShoesDto dto){
        return ResponseEntity.ok(shoesService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        shoesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
