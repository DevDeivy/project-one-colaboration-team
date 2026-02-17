package com.example.project_one_colaboration_team.shirts.controller;

import com.example.project_one_colaboration_team.shirts.dto.ShirtsDTO;
import com.example.project_one_colaboration_team.shirts.service.ShirtsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ShirtsController {

    private final ShirtsService shirtsService;

    @GetMapping("/shirts")
    public ResponseEntity<?> getAllshirts(){
        return ResponseEntity.ok().body(shirtsService.getShirts());
    }

    @PostMapping("/shirts/")
    public ResponseEntity<?> createShirt(@RequestBody ShirtsDTO shirtsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(shirtsService.createShirts(shirtsDTO));
    }

    @PutMapping("/shirts/{id}")
    public ResponseEntity<?> updateShirt(@PathVariable Long id, @RequestBody ShirtsDTO shirtsDTO){
        return ResponseEntity.ok().body(shirtsService.updateShirts(id, shirtsDTO));
    }

    @DeleteMapping("/shirts/{id}")
    public ResponseEntity<?> deleteShirt(@PathVariable Long id){
        return ResponseEntity.ok().body(shirtsService.deleteShirts(id));
    }
}
