package com.example.task.service;

import com.example.task.converters.LordConverter;
import com.example.task.dto.LordDto;
import com.example.task.models.Lord;
import com.example.task.repository.LordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class LordServiceImplTest {

    @Autowired
    private LordServiceImpl lordService;
    @Autowired
    private LordConverter lordConverter;

    @MockBean
    private LordRepository lordRepository;

    @Test
    void createLord() {
        Lord lord = new Lord(1L, "name", 20, Collections.emptyList());
        when(lordRepository.save(any(Lord.class)))
                .thenReturn(lord);
        LordDto lordDto = lordService.createLord(lordConverter.toDto(lord));
        assertEquals(lordConverter.toDto(lord), lordDto);
    }

    @Test
    void findLordsWithoutPlanet() {
        Lord lord = new Lord(1L, "name", 20, Collections.emptyList());
        when(lordRepository.findAll())
                .thenReturn(Collections.singletonList(lord));
        List<LordDto> idlers = lordService.findLordsWithoutPlanet();
        assertEquals(Collections.singletonList(lordConverter.toDto(lord)),
                idlers);
    }

    @Test
    void findTenYoungestLords() {
        Lord lord = new Lord(1L, "name", 20, Collections.emptyList());
        when(lordRepository.findAll())
                .thenReturn(Collections.singletonList(lord));
        List<LordDto> youngest = lordService.findLordsWithoutPlanet();
        assertEquals(Collections.singletonList(lordConverter.toDto(lord)),
                youngest);
    }

    @Test
    void findAll() {
        Lord lord = new Lord(1L, "name", 20, Collections.emptyList());
        when(lordRepository.findAll())
                .thenReturn(Collections.singletonList(lord));
        List<LordDto> listLordDto = lordService.findAll();
        assertEquals(Collections.singletonList(lordConverter.toDto(lord)),
                listLordDto);
    }
}