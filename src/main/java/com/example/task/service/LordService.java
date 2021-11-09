package com.example.task.service;

import com.example.task.dto.LordDto;
import com.example.task.models.Lord;

import java.util.List;

public interface LordService {

    LordDto createLord(LordDto lordDto);
    List<LordDto> findLordsWithoutPlanet();
    List<LordDto> findTenYoungestLords();
    List<LordDto> findAll();
}
