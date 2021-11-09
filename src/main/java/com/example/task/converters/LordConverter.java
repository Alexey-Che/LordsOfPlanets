package com.example.task.converters;

import com.example.task.dto.LordDto;
import com.example.task.models.Lord;
import com.example.task.models.Planet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LordConverter {

    public LordDto convertLordToLordDto(Lord lord){
        LordDto lordDto = new LordDto();
        lordDto.setName(lord.getName());
        lordDto.setAge(lord.getAge());
        List<String> namesOfPlanet = new ArrayList<>();
        for (Planet element: lord.getPlanets()) {
            namesOfPlanet.add(element.getName());
        }
        lordDto.setPlanets(namesOfPlanet);
        return lordDto;
    }

    public Lord convertLordDtoToLord(LordDto lordDto){
        Lord lord = new Lord();
        lord.setName(lordDto.getName());
        lord.setAge(lordDto.getAge());
        return lord;
    }
}
