package com.example.task.service;

import com.example.task.dto.PlanetDto;
import com.example.task.models.Planet;

import java.util.List;

public interface PlanetService {

    PlanetDto createPlanet(PlanetDto planetDto);
    void setLordToRulePlanet(PlanetDto planetDto, String nameOfLord);
    void deletePlanet(String nameOfPlanet);
    List<PlanetDto> findAll();
}
