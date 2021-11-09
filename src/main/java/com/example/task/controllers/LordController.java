package com.example.task.controllers;

import com.example.task.dto.LordDto;
import com.example.task.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lord")
public class LordController {

    private final LordService lordService;

    @Autowired
    public LordController(LordService lordService) {
        this.lordService = lordService;
    }

    @GetMapping("/lords")
    public List<LordDto> getLords() {
        return lordService.findAll();
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public LordDto createLord(@RequestBody @Valid LordDto lordDto) {
        return lordService.createLord(lordDto);
    }

    @GetMapping("/young")
    @ResponseBody
    public List<LordDto> getYoungestLords() {
        return lordService.findTenYoungestLords();
    }

    @GetMapping("/idlers")
    @ResponseBody
    public List<LordDto> getIdlers() {
        return lordService.findLordsWithoutPlanet();
    }
}
