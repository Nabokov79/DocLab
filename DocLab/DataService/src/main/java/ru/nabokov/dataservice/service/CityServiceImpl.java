package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.city.CityDto;
import ru.nabokov.dataservice.dto.city.NewCityDto;
import ru.nabokov.dataservice.dto.city.UpdateCityDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.CityMapper;
import ru.nabokov.dataservice.model.City;
import ru.nabokov.dataservice.repository.CityRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final CityMapper mapper;

    @Override
    public CityDto save(NewCityDto cityDto) {
        if (repository.existsByName(cityDto.getName())) {
            throw new BadRequestException(String.format("city=%s found.", cityDto.getName()));
        }
        return mapper.mapToCityDto(repository.save(mapper.mapToNewCity(cityDto)));
    }

    @Override
    public CityDto update(UpdateCityDto cityDto) {
        if (!repository.existsById(cityDto.getId())) {
            throw new NotFoundException(String.format("city with id=%s not found for update.", cityDto.getId()));
        }
        return mapper.mapToCityDto(repository.save(mapper.mapToUpdateCity(cityDto)));
    }

    @Override
    public City get(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                                                               String.format("city with id=%s not found for set", id)));
    }

    @Override
    public List<CityDto> getAll() {
        return mapper.mapToCityDto(repository.findAll());
    }

    @Override
    public String delete(Long id) {
        City city = repository.findById(id).orElseThrow(() -> new NotFoundException(
                                                  String.format("city with id=%s not found for delete.", id)));
        repository.deleteById(id);
        return city.getName();
    }
}
