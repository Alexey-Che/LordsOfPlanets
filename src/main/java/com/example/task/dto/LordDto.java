package com.example.task.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class LordDto {

    @NotBlank
    @Size(min = 2)
    private String name;
    @NotNull
    private int age;
    private List<String> planets = new ArrayList<>();
}
