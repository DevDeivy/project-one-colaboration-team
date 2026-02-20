package com.example.project_one_colaboration_team.shoes.service;

import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
import com.example.project_one_colaboration_team.shoes.dto.ShoesDto;
import com.example.project_one_colaboration_team.shoes.mapper.ShoesMapper;
import com.example.project_one_colaboration_team.shoes.model.Shoes;
import com.example.project_one_colaboration_team.shoes.repository.ShoesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ShoesServiceTest {

    @Mock
    private ShoesRepository shoesRepository;

    @InjectMocks
    private ShoesService shoesService;

    @Test
    void shouldSaveShoesSuccessfully() {

        ShoesDto dto = ShoesDto.builder()
                .id(1L)
                .brand("Nike")
                .category(ProductCategory.SHOES)
                .price(200.0)
                .size(42)
                .build();

        Shoes entity = ShoesMapper.toEntity(dto);

        when(shoesRepository.save(any(Shoes.class))).thenReturn(entity);

        ShoesDto result = shoesService.save(dto);

        assertNotNull(result);
        assertEquals("Nike", result.getBrand());
        assertEquals(ProductCategory.SHOES, result.getCategory());
        assertEquals(200.0, result.getPrice());
        assertEquals(42, result.getSize());

        verify(shoesRepository, times(1)).save(any(Shoes.class));
    }

    @Test
    void shouldReturnAllShoes() {

        Shoes shoes1 = new Shoes();
        shoes1.setId(1L);
        shoes1.setBrand("Nike");
        shoes1.setCategory(ProductCategory.SHOES);
        shoes1.setPrice(200.0);
        shoes1.setSize(42);

        Shoes shoes2 = new Shoes();
        shoes2.setId(2L);
        shoes2.setBrand("Adidas");
        shoes2.setCategory(ProductCategory.SHOES);
        shoes2.setPrice(180.0);
        shoes2.setSize(41);

        when(shoesRepository.findAll()).thenReturn(List.of(shoes1, shoes2));

        List<ShoesDto> result = shoesService.findAll();

        assertEquals(2, result.size());
        verify(shoesRepository, times(1)).findAll();
    }

    @Test
    void shouldUpdateShoesSuccessfully() {

        long id = 1L;

        Shoes existing = new Shoes();
        existing.setId(id);
        existing.setBrand("OldBrand");
        existing.setCategory(ProductCategory.SHOES);
        existing.setPrice(100.0);
        existing.setSize(40);

        ShoesDto updateDto = ShoesDto.builder()
                .brand("NewBrand")
                .category(ProductCategory.SHOES)
                .price(250.0)
                .size(43)
                .build();

        when(shoesRepository.findById(id)).thenReturn(Optional.of(existing));
        when(shoesRepository.save(any(Shoes.class))).thenReturn(existing);

        ShoesDto result = shoesService.update(id, updateDto);

        assertEquals("NewBrand", result.getBrand());
        assertEquals(ProductCategory.SHOES, result.getCategory());
        assertEquals(250.0, result.getPrice());
        assertEquals(43, result.getSize());

        verify(shoesRepository).findById(id);
        verify(shoesRepository).save(existing);
    }

    @Test
    void shouldThrowExceptionWhenShoesNotFoundOnUpdate() {

        long id = 99L;

        ShoesDto dto = ShoesDto.builder().build();

        when(shoesRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> shoesService.update(id, dto));

        assertEquals("Shoes not found", exception.getMessage());

        verify(shoesRepository).findById(id);
        verify(shoesRepository, never()).save(any());
    }

    @Test
    void shouldDeleteShoesSuccessfully() {

        Long id = 1L;

        doNothing().when(shoesRepository).deleteById(id);

        shoesService.delete(id);

        verify(shoesRepository, times(1)).deleteById(id);
    }
}
