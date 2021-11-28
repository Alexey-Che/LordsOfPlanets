package com.example.task.service;

import com.example.task.converters.PlanetConverter;
import com.example.task.dto.PlanetDto;
import com.example.task.models.Lord;
import com.example.task.models.Planet;
import com.example.task.repository.LordRepository;
import com.example.task.repository.PlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService{

    private final PlanetRepository planetRepository;
    private final LordRepository lordRepository;
    private final PlanetConverter planetConverter;

    @Override
    public PlanetDto createPlanet(PlanetDto planetDto) {
        if (planetRepository.getByName(planetDto.getName()) != null) {
            return planetDto;
        }
        return planetConverter.toDto(planetRepository.save(planetConverter.toEntity(planetDto)));
    }

    @Override
    public PlanetDto setLordToRulePlanet(PlanetDto planetDto, String nameOfLord) {
        Lord lord = lordRepository.getByName(nameOfLord);
        Planet planet = planetRepository.getByName(planetDto.getName());
        planet.setLord(lord);
        return planetConverter.toDto(planetRepository.save(planet));
    }

    @Override
    public void deletePlanet(String nameOfPlanet) {
        planetRepository.deleteByName(nameOfPlanet);
    }

    @Override
    public List<PlanetDto> findAll() {
        return planetRepository.findAll()
                .stream()
                .map(planetConverter::toDto)
                .collect(Collectors.toList());
    }
}
