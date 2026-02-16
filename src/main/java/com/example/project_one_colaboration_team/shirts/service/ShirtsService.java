package com.example.project_one_colaboration_team.application.services;

import com.example.project_one_colaboration_team.infraestructure.repository.ShirtsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShirtsService {

    private final ShirtsRepository shirtsRepository;
}
