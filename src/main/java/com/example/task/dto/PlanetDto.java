package com.example.task.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PlanetDto {

    @NotBlank
    @Size(min = 2)
    private String name;
    private String lord;
}
