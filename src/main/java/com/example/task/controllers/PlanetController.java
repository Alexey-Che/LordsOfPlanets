package com.example.task.controllers;

import com.example.task.dto.PlanetDto;
import com.example.task.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planet")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @GetMapping("/planets")
    @ResponseBody
    public List<PlanetDto> getPlanets() {
        return planetService.findAll();

    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDto createPlanet(@RequestBody @Valid PlanetDto planetDto) {
        return planetService.createPlanet(planetDto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlanet(@RequestParam("nameOfPlanet") String nameOfPlanet) {
        planetService.deletePlanet(nameOfPlanet);
    }

    @PostMapping("/set")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PlanetDto setLord(@RequestBody @Valid PlanetDto planetDto,
                           @RequestParam("nameOfLord") String nameOfLord) {
        return planetService.setLordToRulePlanet(planetDto, nameOfLord);
    }
}
