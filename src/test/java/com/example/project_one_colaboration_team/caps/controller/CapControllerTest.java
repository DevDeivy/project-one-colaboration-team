package com.example.project_one_colaboration_team.caps.controller;

import com.example.project_one_colaboration_team.caps.dto.CapDto;
import com.example.project_one_colaboration_team.caps.service.CapService;
import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CapController.class)
class CapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CapService capService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create_shouldReturnCreatedCap() throws Exception {

        CapDto dto = new CapDto(
                1L,
                ProductCategory.CAP,
                "BOSS",
                100.0,
                "Green"
        );

        when(capService.save(any(CapDto.class))).thenReturn(dto);

        mockMvc.perform(post("/api/products/cap")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("BOSS"))
                .andExpect(jsonPath("$.price").value(100.0))
                .andExpect(jsonPath("$.color").value("Green"));
    }

    @Test
    void getAll_shouldReturnList() throws Exception {

        CapDto dto1 = new CapDto(1L, ProductCategory.CAP, "BOSS", 100.0, "Green");
        CapDto dto2 = new CapDto(2L, ProductCategory.CAP, "NIKE", 80.0, "Black");

        when(capService.getAll()).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/api/products/cap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].brand").value("BOSS"))
                .andExpect(jsonPath("$[1].brand").value("NIKE"));
    }

    @Test
    void update_shouldReturnUpdatedCap() throws Exception {

        Long id = 1L;

        CapDto updated = new CapDto(
                id,
                ProductCategory.CAP,
                "NEW",
                120.0,
                "Red"
        );

        when(capService.update(any(Long.class), any(CapDto.class)))
                .thenReturn(updated);

        mockMvc.perform(put("/api/products/cap/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("NEW"))
                .andExpect(jsonPath("$.price").value(120.0))
                .andExpect(jsonPath("$.color").value("Red"));
    }

    @Test
    void delete_shouldReturnNoContent() throws Exception {

        Long id = 1L;

        doNothing().when(capService).deleteDyId(id);

        mockMvc.perform(delete("/api/products/cap/{id}", id))
                .andExpect(status().isNoContent());
    }
}
