package com.example.project_one_colaboration_team.authentication.service;

import com.example.project_one_colaboration_team.authentication.dto.TokenResponseDTO;
import com.example.project_one_colaboration_team.authentication.dto.UserRequestDTO;
import com.example.project_one_colaboration_team.authentication.dto.UserResponseDTO;
import com.example.project_one_colaboration_team.authentication.mapper.UserMapper;
import com.example.project_one_colaboration_team.authentication.model.User;
import com.example.project_one_colaboration_team.authentication.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDTO)
                .toList();
    }

    public TokenResponseDTO createUser(UserRequestDTO userRequestDTO){
        if (userRequestDTO == null) return null;
        if (userRepository.existsByEmail(userRequestDTO.getEmail()))throw new IllegalArgumentException("email is already exists");
        User user = userMapper.dtoToEntity(userRequestDTO);
        User saved = userRepository.save(user);
        UserResponseDTO userResponse = userMapper.entityToDTO(saved);
        var token = jwtService.getToken(saved);
        TokenResponseDTO response = new TokenResponseDTO(userResponse, token);
        return response;
    }

    public UserResponseDTO updateUser(Long id,UserRequestDTO userRequestDTO){
        var optionalUser = userRepository.findById(id);
        if (!userRepository.existsById(id) || optionalUser.isEmpty()) throw new IllegalArgumentException("this can´t be null");
        User user = optionalUser.get();
        userMapper.updateEntityFromDTO(userRequestDTO, user);
        User saved = userRepository.save(user);
        return userMapper.entityToDTO(saved);
    }

    public String deleteUser(Long id){
        if (id == null) throw new IllegalArgumentException("id can´t be null");
        if (!userRepository.existsById(id)) throw new EntityNotFoundException("enter a valid id");
        userRepository.deleteById(id);
        return "User deleted";
    }
}


















