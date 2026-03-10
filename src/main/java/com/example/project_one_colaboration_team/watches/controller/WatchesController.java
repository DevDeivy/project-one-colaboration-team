package com.example.project_one_colaboration_team.watches.controller;

import com.example.project_one_colaboration_team.watches.dto.WatchesRequestDTO;
import com.example.project_one_colaboration_team.watches.dto.WatchesResponseDTO;
import com.example.project_one_colaboration_team.watches.service.WatchesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class WatchesController {

    private final WatchesService watchesService;

    @GetMapping("/watches")
    public ResponseEntity<List<WatchesResponseDTO>> getAllWatches(){
        return ResponseEntity.ok(watchesService.getWatches());
    }

    @PostMapping("/watches")
    public ResponseEntity<WatchesResponseDTO> createWatch(@RequestBody @Valid WatchesRequestDTO watchesRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(watchesService.createWatch(watchesRequestDTO));
    }

    @PutMapping("/watches/{id}")
    public ResponseEntity<WatchesResponseDTO> updateWatch( @PathVariable @Valid Long id, @RequestBody WatchesRequestDTO watchesRequestDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(watchesService.updateWatch(id, watchesRequestDTO));
    }

    @DeleteMapping("/watches/{id}")
    public ResponseEntity<String> deleteWatch(@PathVariable @Valid Long id){
        return ResponseEntity.ok().body(watchesService.deleteWatch(id));
    }
}
