package com.example.task.service;

import com.example.task.converters.PlanetConverter;
import com.example.task.dto.PlanetDto;
import com.example.task.models.Lord;
import com.example.task.models.Planet;
import com.example.task.repository.LordRepository;
import com.example.task.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService{

    private final PlanetRepository planetRepository;
    private final LordRepository lordRepository;
    private final PlanetConverter planetConverter;

    @Autowired
    public PlanetServiceImpl(PlanetRepository planetRepository, LordRepository lordRepository, PlanetConverter planetConverter) {
        this.planetRepository = planetRepository;
        this.lordRepository = lordRepository;
        this.planetConverter = planetConverter;
    }

    @Override
    public PlanetDto createPlanet(PlanetDto planetDto) {
        return planetConverter.convertPlanetToPlanetDto(planetRepository.save(planetConverter.convertPlanetDtoToPlanet(planetDto)));
    }

    @Override
    public void setLordToRulePlanet(PlanetDto planetDto, String nameOfLord) {
        Lord lord = lordRepository.getByName(nameOfLord);
        Planet planet = planetRepository.getByName(planetDto.getName());
        lord.getPlanets().add(planet);
        lordRepository.save(lord);
    }

    @Override
    public void deletePlanet(String nameOfPlanet) {
        planetRepository.deleteByName(nameOfPlanet);
    }

    @Override
    public List<PlanetDto> findAll() {
        return planetRepository.findAll()
                .stream()
                .map(planetConverter::convertPlanetToPlanetDto)
                .collect(Collectors.toList());
    }
}
