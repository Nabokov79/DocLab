package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.manufacturer.ManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.NewManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.UpdateManufacturerDto;
import ru.nabokov.dataservice.model.Manufacturer;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    Manufacturer mapToNewManufacturer(NewManufacturerDto manufacturerDto);

    ManufacturerDto mapToManufacturerDto(Manufacturer manufacturer);

    Manufacturer mapToUpdateManufacturer(UpdateManufacturerDto manufacturerDto);

    List<ManufacturerDto> mapToManufacturersDto(List<Manufacturer> manufacturers);
}
