package com.example.task.service;

import com.example.task.converters.PlanetConverter;
import com.example.task.dto.PlanetDto;
import com.example.task.models.Planet;
import com.example.task.repository.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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