package com.example.project_one_colaboration_team.caps.controller;

import com.example.project_one_colaboration_team.caps.dto.CapDto;
import com.example.project_one_colaboration_team.caps.service.CapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cap")
@RequiredArgsConstructor
public class CapController {
    private final CapService capService;

    @PostMapping
    private ResponseEntity<CapDto> create(@RequestBody CapDto dto){
        return ResponseEntity.ok(capService.save(dto));
    }

    @GetMapping
    private ResponseEntity<List<CapDto>> getAll(){
        return ResponseEntity.ok(capService.getAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CapDto> getById(@PathVariable long id){
        return ResponseEntity.ok(capService.findById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable long id){
        capService.deleteDyId(id);
        return ResponseEntity.noContent().build();
    }
}
