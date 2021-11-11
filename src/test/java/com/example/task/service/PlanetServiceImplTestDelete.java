package com.example.task.service;

import com.example.task.repository.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlanetServiceImplTestDelete {

    @Mock
    private PlanetRepository planetRepository;

    @InjectMocks
    private PlanetServiceImpl planetService;

    @Test
    void deletePlanet() {
        final String planetName = "planet";
        planetService.deletePlanet(planetName);
        planetService.deletePlanet(planetName);
        verify(planetRepository, times(2)).deleteByName(planetName);
    }
}