package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.city.CityDto;
import ru.nabokov.dataservice.dto.city.NewCityDto;
import ru.nabokov.dataservice.dto.city.UpdateCityDto;
import ru.nabokov.dataservice.model.City;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City mapToNewCity(NewCityDto cityDto);

    CityDto mapToCityDto(City city);

    City mapToUpdateCity(UpdateCityDto cityDto);

    List<CityDto> mapToCityDto(List<City> cities);
}
