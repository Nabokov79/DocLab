package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.building.BuildingDto;
import ru.nabokov.dataservice.dto.building.NewBuildingDto;
import ru.nabokov.dataservice.dto.building.UpdateBuildingDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.BuildingMapper;
import ru.nabokov.dataservice.model.Building;
import ru.nabokov.dataservice.repository.BuildingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repository;
    private final BuildingMapper mapper;

    @Override
    public BuildingDto save(NewBuildingDto buildingDto) {
        return mapper.mapToBuildingDto(repository.save(mapper.mapToNewBuilding(buildingDto)));
    }

    @Override
    public BuildingDto update(UpdateBuildingDto buildingDto) {
        if (!repository.existsById(buildingDto.getId())) {
            throw new BadRequestException(String.format("building with id=%s not found for update",buildingDto.getId()));
        }
        return mapper.mapToBuildingDto(repository.save(mapper.mapToUpdateBuilding(buildingDto)));
    }

    @Override
    public Building get(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException(String.format("building with id=%s not found", id)));
    }

    @Override
    public List<BuildingDto> getAll() {
        List<Building> buildings = repository.findAll();
        if (buildings.isEmpty()) {
            throw new NotFoundException(String.format("buildings not found, buildings=%s", buildings));
        }
        return mapper.mapToBuildingsDto(buildings);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new BadRequestException(String.format("building with id=%s not found for delete", id));

    }
}
