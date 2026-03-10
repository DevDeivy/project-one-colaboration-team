package com.example.project_one_colaboration_team.authentication.controller;

import com.example.project_one_colaboration_team.authentication.dto.TokenResponseDTO;
import com.example.project_one_colaboration_team.authentication.dto.UserRequestDTO;
import com.example.project_one_colaboration_team.authentication.dto.UserResponseDTO;
import com.example.project_one_colaboration_team.authentication.service.UserService;
import jakarta.validation.Valid;
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
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<TokenResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok().body(userService.createUser(userRequestDTO));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok().body(userService.updateUser(id, userRequestDTO));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@Valid @PathVariable Long id){
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }
}
