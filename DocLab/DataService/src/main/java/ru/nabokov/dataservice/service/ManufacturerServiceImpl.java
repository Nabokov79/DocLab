package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.manufacturer.ManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.NewManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.UpdateManufacturerDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.ManufacturerMapper;
import ru.nabokov.dataservice.model.Manufacturer;
import ru.nabokov.dataservice.repository.ManufacturerRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository repository;
    private final ManufacturerMapper mapper;

    @Override
    public ManufacturerDto save(NewManufacturerDto manufacturerDto) {
        if (repository.existsByName(manufacturerDto.getName())) {
            throw new BadRequestException(
                    String.format("manufacturer=%s found.", manufacturerDto.getName())
            );
        }
        Manufacturer manufacturer = mapper.mapToNewManufacturer(manufacturerDto);
        return mapper.mapToManufacturerDto(repository.save(manufacturer));
    }

    @Override
    public ManufacturerDto update(UpdateManufacturerDto manufacturerDto) {
        if (!repository.existsById(manufacturerDto.getId())) {
            throw new NotFoundException(
                    String.format("manufacturer=%s not found for update.", manufacturerDto.getName())
            );
        }
        Manufacturer manufacturer = mapper.mapToUpdateManufacturer(manufacturerDto);
        return mapper.mapToManufacturerDto(repository.save(manufacturer));
    }

    @Override
    public List<ManufacturerDto> getAll() {
        return mapper.mapToManufacturersDto(repository.findAll());
    }

    @Override
    public String delete(Long id) {
        Manufacturer manufacturer = repository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format("manufacturer with id=%s not found for delete.", id))
                );
        repository.deleteById(id);
        return manufacturer.getName();
    }
}
