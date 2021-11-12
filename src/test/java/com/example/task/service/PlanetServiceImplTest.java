package com.example.task.service;

import com.example.task.converters.PlanetConverter;
import com.example.task.dto.PlanetDto;
import com.example.task.models.Lord;
import com.example.task.models.Planet;
import com.example.task.repository.LordRepository;
import com.example.task.repository.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlanetServiceImplTest {

    @Autowired
    private PlanetConverter planetConverter;
    @Autowired
    private PlanetServiceImpl planetService;
    @MockBean
    private PlanetRepository planetRepository;
    @MockBean
    private LordRepository lordRepository;

    @Test
    void createPlanet() {
        Planet planet = new Planet(1L, "planet");
        PlanetDto  planetDto = planetConverter.toDto(planet);
        when(planetRepository.save(any(Planet.class)))
                .thenReturn(planet);
        PlanetDto expectedPlanet = planetService.createPlanet(planetDto);
        assertEquals(planetDto, expectedPlanet);
    }

    @Test
    void setLordToRulePlanet() {
        Lord lord = new Lord(1L, "name", 20, Collections.emptyList());
        Planet planet = new Planet(1L, "planet");
        Planet planetWithLord = new Planet(1L, "planet", lord);
        PlanetDto planetWithLordDto = planetConverter.toDto(planetWithLord);
        when(lordRepository.getByName(lord.getName()))
                .thenReturn(lord);
        when(planetRepository.getByName(planet.getName()))
                .thenReturn(planet);
        when(planetRepository.save(any(Planet.class)))
                .thenReturn(planetWithLord);
        PlanetDto planetDto = planetService.setLordToRulePlanet(planetWithLordDto, lord.getName());
        assertEquals(planetWithLordDto, planetDto);
    }

    @Test
    void findAll() {
        Planet planet = new Planet(1L, "planet");
        PlanetDto planetDto = planetConverter.toDto(planet);
        when(planetRepository.findAll())
                .thenReturn(Collections.singletonList(planet));
        List<PlanetDto> list = planetService.findAll();
        assertEquals(Collections.singletonList(planetDto), list);
    }
}