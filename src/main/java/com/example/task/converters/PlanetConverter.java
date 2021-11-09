package com.example.task.converters;

import com.example.task.dto.PlanetDto;
import com.example.task.models.Planet;
import org.springframework.stereotype.Service;

@Service
public class PlanetConverter {

    public PlanetDto convertPlanetToPlanetDto(Planet planet){
        PlanetDto planetDto = new PlanetDto();
        planetDto.setName(planet.getName());
        return planetDto;
    }

    public Planet convertPlanetDtoToPlanet(PlanetDto planetDto){
        Planet planet = new Planet();
        planet.setName(planetDto.getName());
        return planet;
    }
}
