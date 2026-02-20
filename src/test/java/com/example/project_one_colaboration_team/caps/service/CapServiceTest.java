package com.example.project_one_colaboration_team.caps.service;

import com.example.project_one_colaboration_team.caps.dto.CapDto;
import com.example.project_one_colaboration_team.caps.mapper.CapMapper;
import com.example.project_one_colaboration_team.caps.model.Cap;
import com.example.project_one_colaboration_team.caps.repository.CapRepository;
import com.example.project_one_colaboration_team.domain.Models.ProductCategory;
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
class CapServiceTest {

    @Mock
    private CapRepository capRepository;

    @InjectMocks
    private CapService capService;

    @Test
    void save_shouldReturnSavedDto() {

        CapDto inputDto = new CapDto(
                1L,
                ProductCategory.CAP,
                "BOSS",
                100.0,
                "Green"
        );

        Cap entity = CapMapper.toEntity(inputDto);

        when(capRepository.save(any(Cap.class))).thenReturn(entity);

        CapDto result = capService.save(inputDto);

        assertNotNull(result);
        assertEquals("BOSS", result.getBrand());
        assertEquals(ProductCategory.CAP, result.getCategory());
        assertEquals(100.0, result.getPrice());
        assertEquals("Green", result.getColor());

        verify(capRepository, times(1)).save(any(Cap.class));
    }

    @Test
    void getAll_shouldReturnListOfDtos() {

        Cap cap1 = new Cap();
        cap1.setId(1L);
        cap1.setCategory(ProductCategory.CAP);
        cap1.setBrand("BOSS");
        cap1.setPrice(100.0);
        cap1.setColor("Green");

        Cap cap2 = new Cap();
        cap2.setId(2L);
        cap2.setCategory(ProductCategory.CAP);
        cap2.setBrand("NIKE");
        cap2.setPrice(80.0);
        cap2.setColor("Black");

        when(capRepository.findAll()).thenReturn(List.of(cap1, cap2));

        List<CapDto> result = capService.getAll();

        assertEquals(2, result.size());
        assertEquals("BOSS", result.get(0).getBrand());
        assertEquals("NIKE", result.get(1).getBrand());

        verify(capRepository, times(1)).findAll();
    }

    @Test
    void update_shouldReturnUpdatedDto() {

        Long id = 1L;

        Cap existing = new Cap();
        existing.setId(id);
        existing.setCategory(ProductCategory.CAP);
        existing.setBrand("OLD");
        existing.setPrice(50.0);
        existing.setColor("Blue");

        CapDto updateDto = new CapDto(
                id,
                ProductCategory.CAP,
                "NEW",
                120.0,
                "Red"
        );

        when(capRepository.findById(id)).thenReturn(Optional.of(existing));
        when(capRepository.save(any(Cap.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        CapDto result = capService.update(id, updateDto);

        assertEquals("NEW", result.getBrand());
        assertEquals(120.0, result.getPrice());
        assertEquals("Red", result.getColor());

        verify(capRepository).findById(id);
        verify(capRepository).save(existing);
    }

    @Test
    void update_shouldThrowException_whenCapNotFound() {

        Long id = 1L;

        when(capRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> capService.update(id, new CapDto())
        );

        assertEquals("Cap not found", exception.getMessage());

        verify(capRepository).findById(id);
        verify(capRepository, never()).save(any());
    }

    @Test
    void deleteDyId_shouldCallRepository() {

        Long id = 1L;

        doNothing().when(capRepository).deleteById(id);

        capService.deleteDyId(id);

        verify(capRepository, times(1)).deleteById(id);
    }
}
