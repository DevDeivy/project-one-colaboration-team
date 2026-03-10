package com.example.project_one_colaboration_team.shirts.controller;

import com.example.project_one_colaboration_team.shirts.dto.ShirtsRequestDTO;
import com.example.project_one_colaboration_team.shirts.dto.ShirtsResponseDTO;
import com.example.project_one_colaboration_team.shirts.service.ShirtsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ShirtsController {

    private final ShirtsService shirtsService;

    @GetMapping("/shirts")
    public ResponseEntity<List<ShirtsResponseDTO>> getAllshirts(){
        return ResponseEntity.ok().body(shirtsService.getShirts());
    }

    @PostMapping("/shirts")
    public ResponseEntity<ShirtsResponseDTO> createShirt(@Valid @RequestBody ShirtsRequestDTO shirtsRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(shirtsService.createShirts(shirtsRequestDTO));
    }

    @PutMapping("/shirts/{id}")
    public ResponseEntity<ShirtsResponseDTO> updateShirt(@Valid @PathVariable Long id, @RequestBody ShirtsRequestDTO shirtsRequestDTO){
        return ResponseEntity.ok().body(shirtsService.updateShirts(id, shirtsRequestDTO));
    }

    @DeleteMapping("/shirts/{id}")
    public ResponseEntity<?> deleteShirt(@PathVariable Long id){
        return ResponseEntity.ok().body(shirtsService.deleteShirts(id));
    }
}
