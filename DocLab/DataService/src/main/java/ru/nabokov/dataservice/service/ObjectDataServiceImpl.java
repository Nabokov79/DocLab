package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.objectData.NewObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.ObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.UpdateObjectDataDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.ObjectDataMapper;
import ru.nabokov.dataservice.mapper.TypeMapper;
import ru.nabokov.dataservice.model.ObjectData;
import ru.nabokov.dataservice.repository.ObjectDataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectDataServiceImpl implements ObjectDataService {

    private final ObjectDataRepository repository;
    private final ObjectDataMapper mapper;
    private final TypeService typeService;
    private final TypeMapper typeMapper;
    private final BuildingService buildingService;

    @Override
    public ObjectDataDto save(NewObjectDataDto objectDataDto) {
        ObjectData object = mapper.mapToNewObjectData(objectDataDto);
        object.setType(typeMapper.mapToType(typeService.get(objectDataDto.getTypeId())));
        object.setBuilding(buildingService.get(objectDataDto.getBuildingId()));
        return mapper.mapToObjectDataDto(repository.save(object));
    }

    @Override
    public ObjectDataDto update(UpdateObjectDataDto objectDataDto) {
        if (!repository.existsById(objectDataDto.getId())) {
            throw new BadRequestException(
                    String.format("Object data with id=%s not found for update", objectDataDto.getId())
            );
        }
        ObjectData object = mapper.mapToUpdateObjectData(objectDataDto);
        object.setType(typeMapper.mapToType(typeService.get(objectDataDto.getTypeId())));
        object.setBuilding(buildingService.get(objectDataDto.getBuildingId()));
        return mapper.mapToObjectDataDto(repository.save(object));
    }

    @Override
    public List<ObjectDataDto> getAll(Long typeId) {
        if (typeId == null) {
            return mapper.mapToObjectsDataDto(repository.findAll());
        } else {
            return mapper.mapToObjectsDataDto(
                    new ArrayList<>(repository.findAllByType(typeMapper.mapToType(typeService.get(typeId))))
            );
        }
    }

    @Override
    public ObjectDataDto get(Long id) {
        return mapper.mapToObjectDataDto(repository.findById(id).orElseThrow(() -> new NotFoundException(
                String.format(String.format("Object data with id=%s not found", id)))
        ));
    }

    @Override
    public String delete(Long id) {
        ObjectDataDto object = get(id);
        repository.deleteById(id);
        return object.getType().getName();
    }
}
