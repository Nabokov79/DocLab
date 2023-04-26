package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.building.BuildingDto;
import ru.nabokov.dataservice.dto.building.NewBuildingDto;
import ru.nabokov.dataservice.dto.building.UpdateBuildingDto;
import ru.nabokov.dataservice.model.Building;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BuildingMapper {

    Building mapToNewBuilding(NewBuildingDto buildingDto);

    Building mapToUpdateBuilding(UpdateBuildingDto buildingDto);

    BuildingDto mapToBuildingDto(Building building);

    List<BuildingDto> mapToBuildingsDto(List<Building> buildings);
}
