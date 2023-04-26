package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.city.CityDto;
import ru.nabokov.dataservice.dto.city.NewCityDto;
import ru.nabokov.dataservice.dto.city.UpdateCityDto;
import ru.nabokov.dataservice.model.City;
import java.util.List;

public interface CityService {

    CityDto save(NewCityDto cityDto);

    CityDto update(UpdateCityDto cityDto);

    City get(Long id);

    List<CityDto> getAll();

    String delete(Long id);
}
