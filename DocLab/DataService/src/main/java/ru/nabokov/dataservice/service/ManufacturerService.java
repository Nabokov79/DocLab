package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.manufacturer.ManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.NewManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.UpdateManufacturerDto;
import ru.nabokov.dataservice.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto save(NewManufacturerDto manufacturerDto);

    ManufacturerDto update(UpdateManufacturerDto manufacturerDto);

    Manufacturer get(Long id);

    List<ManufacturerDto> getAll();

    String delete(Long id);
}
