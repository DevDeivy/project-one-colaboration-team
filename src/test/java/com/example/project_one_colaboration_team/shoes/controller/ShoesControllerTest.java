package com.example.project_one_colaboration_team.shoes.controller;

import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
import com.example.project_one_colaboration_team.shoes.dto.ShoesDto;
import com.example.project_one_colaboration_team.shoes.service.ShoesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShoesController.class)
class ShoesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoesService shoesService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateShoes() throws Exception {

        ShoesDto dto = ShoesDto.builder()
                .id(1L)
                .brand("Nike")
                .category(ProductCategory.SHOES)
                .price(250.0)
                .size(42)
                .build();

        when(shoesService.save(any(ShoesDto.class))).thenReturn(dto);

        mockMvc.perform(post("/api/products/shoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Nike"))
                .andExpect(jsonPath("$.category").value("SHOES"))
                .andExpect(jsonPath("$.price").value(250.0))
                .andExpect(jsonPath("$.size").value(42));
    }

    @Test
    void shouldReturnAllShoes() throws Exception {

        ShoesDto dto1 = ShoesDto.builder()
                .id(1L)
                .brand("Nike")
                .category(ProductCategory.SHOES)
                .price(250.0)
                .size(42)
                .build();

        ShoesDto dto2 = ShoesDto.builder()
                .id(2L)
                .brand("Adidas")
                .category(ProductCategory.SHOES)
                .price(180.0)
                .size(41)
                .build();

        when(shoesService.findAll()).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/api/products/shoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].brand").value("Nike"))
                .andExpect(jsonPath("$[1].brand").value("Adidas"));
    }

    @Test
    void shouldUpdateShoes() throws Exception {

        long id = 1L;

        ShoesDto dto = ShoesDto.builder()
                .id(id)
                .brand("NewBrand")
                .category(ProductCategory.SHOES)
                .price(300.0)
                .size(43)
                .build();

        when(shoesService.update(any(Long.class), any(ShoesDto.class))).thenReturn(dto);

        mockMvc.perform(put("/api/products/shoes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("NewBrand"))
                .andExpect(jsonPath("$.price").value(300.0));
    }

    @Test
    void shouldDeleteShoes() throws Exception {

        long id = 1L;

        doNothing().when(shoesService).delete(id);

        mockMvc.perform(delete("/api/products/shoes/{id}", id))
                .andExpect(status().isNoContent());
    }
}
