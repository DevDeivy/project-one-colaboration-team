package com.example.project_one_colaboration_team.watches.controller;

import com.example.project_one_colaboration_team.watches.dto.WatchesDTO;
import com.example.project_one_colaboration_team.watches.service.WatchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class WatchesController {

    private final WatchesService watchesService;

    @GetMapping("/watches")
    public ResponseEntity<?> getAllWatches(){
        return ResponseEntity.ok(watchesService.getWatches());
    }

    @PostMapping("/watches/")
    public ResponseEntity<?> createWatch(@RequestBody WatchesDTO watchesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(watchesService.createWatch(watchesDTO));
    }

    @PutMapping("/watches/{id}")
    public ResponseEntity<?> updateWatch( @PathVariable Long id, @RequestBody WatchesDTO watchesDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(watchesService.updateWatch(id, watchesDTO));
    }

    @DeleteMapping("/watches/{id}")
    public ResponseEntity<?> deleteWatch(@PathVariable Long id){
        return ResponseEntity.ok().body(watchesService.deleteWatch(id));
    }
}
