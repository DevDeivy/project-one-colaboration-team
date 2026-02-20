package com.example.project_one_colaboration_team.shoes.mapper;

import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
import com.example.project_one_colaboration_team.shoes.dto.ShoesDto;
import com.example.project_one_colaboration_team.shoes.model.Shoes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoesMapperTest {

    @Test
    void shouldMapEntityToDtoCorrectly() {

        // Arrange
        Shoes shoes = new Shoes();
        shoes.setId(1L);
        shoes.setCategory(ProductCategory.SHOES);
        shoes.setBrand("Nike");
        shoes.setPrice(250.0);
        shoes.setSize(42);

        // Act
        ShoesDto result = ShoesMapper.toDto(shoes);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(ProductCategory.SHOES, result.getCategory());
        assertEquals("Nike", result.getBrand());
        assertEquals(250.0, result.getPrice());
        assertEquals(42, result.getSize());
    }

    @Test
    void shouldMapDtoToEntityCorrectly() {

        // Arrange
        ShoesDto dto = ShoesDto.builder()
                .id(2L)
                .category(ProductCategory.SHOES)
                .brand("Adidas")
                .price(180.0)
                .size(41)
                .build();

        // Act
        Shoes result = ShoesMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertEquals(ProductCategory.SHOES, result.getCategory());
        assertEquals("Adidas", result.getBrand());
        assertEquals(180.0, result.getPrice());
        assertEquals(41, result.getSize());
    }

    @Test
    void shouldThrowExceptionWhenEntityIsNull() {
        assertThrows(NullPointerException.class,
                () -> ShoesMapper.toDto(null));
    }

    @Test
    void shouldThrowExceptionWhenDtoIsNull() {
        assertThrows(NullPointerException.class,
                () -> ShoesMapper.toEntity(null));
    }
}
