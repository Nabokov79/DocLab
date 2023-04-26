package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.building.BuildingDto;
import ru.nabokov.dataservice.dto.building.NewBuildingDto;
import ru.nabokov.dataservice.dto.building.UpdateBuildingDto;
import ru.nabokov.dataservice.model.Building;

import java.util.List;

public interface BuildingService {

    BuildingDto save(NewBuildingDto buildingDto);

    BuildingDto update(UpdateBuildingDto buildingDto);

    Building get(Long id);

    List<BuildingDto> getAll();

   void delete(Long id);
}
