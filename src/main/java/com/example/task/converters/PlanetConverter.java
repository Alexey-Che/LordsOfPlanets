package com.example.task.converters;

import com.example.task.dto.PlanetDto;
import com.example.task.models.Planet;
import org.springframework.stereotype.Service;

@Service
public class PlanetConverter {

    public PlanetDto toDto(Planet planet){
        PlanetDto planetDto = new PlanetDto();
        planetDto.setName(planet.getName());
        if (planet.getLord() != null){
            planetDto.setLord(planet.getLord().getName());
        }
        return planetDto;
    }

    public Planet toEntity(PlanetDto planetDto){
        Planet planet = new Planet();
        planet.setName(planetDto.getName());
        return planet;
    }
}
