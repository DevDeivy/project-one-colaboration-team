package com.example.project_one_colaboration_team.authentication.mapper;

import com.example.project_one_colaboration_team.authentication.dto.UserRequestDTO;
import com.example.project_one_colaboration_team.authentication.dto.UserResponseDTO;
import com.example.project_one_colaboration_team.authentication.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO entityToDTO(User user){
        if (user == null) return null;
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public User dtoToEntity(UserRequestDTO userRequestDTO){
        if (userRequestDTO == null) return null;
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        return user;
    }

    public UserResponseDTO updateEntityFromDTO(UserRequestDTO userRequestDTO, User user){
        if (userRequestDTO == null|| user == null) throw new IllegalArgumentException("this section can´t be null");
        user.setName(userRequestDTO.getName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        var response = entityToDTO(user);
        return response;
    }

}


















