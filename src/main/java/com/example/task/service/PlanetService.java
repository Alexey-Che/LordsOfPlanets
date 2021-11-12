package com.example.task.service;

import com.example.task.dto.LordDto;
import com.example.task.dto.PlanetDto;

import java.util.List;

public interface PlanetService {

    PlanetDto createPlanet(PlanetDto planetDto);
    PlanetDto setLordToRulePlanet(PlanetDto planetDto, String nameOfLord);
    void deletePlanet(String nameOfPlanet);
    List<PlanetDto> findAll();
}
