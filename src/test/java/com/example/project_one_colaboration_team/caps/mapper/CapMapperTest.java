package com.example.project_one_colaboration_team.caps.mapper;

import com.example.project_one_colaboration_team.caps.dto.CapDto;
import com.example.project_one_colaboration_team.caps.model.Cap;
import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CapMapperTest {

    @Test
    void shouldMapCapToDtoCorrectly() {
        // Arrange
        Cap cap = new Cap();
        cap.setId(1L);
        cap.setCategory(ProductCategory.CAP);
        cap.setBrand("Nike");
        cap.setPrice(120.0);
        cap.setColor("Black");

        // Act
        CapDto result = CapMapper.toDto(cap);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(ProductCategory.CAP, result.getCategory());
        assertEquals("Nike", result.getBrand());
        assertEquals(120.0, result.getPrice());
        assertEquals("Black", result.getColor());
    }

    @Test
    void shouldMapDtoToEntityCorrectly() {
        // Arrange
        CapDto capDto = CapDto.builder()
                .id(2L)
                .category(ProductCategory.CAP)
                .brand("Adidas")
                .price(95.5)
                .color("White")
                .build();

        // Act
        Cap result = CapMapper.toEntity(capDto);

        // Assert
        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertEquals(ProductCategory.CAP, result.getCategory());
        assertEquals("Adidas", result.getBrand());
        assertEquals(95.5, result.getPrice());
        assertEquals("White", result.getColor());
    }
}
