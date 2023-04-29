package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.objectData.NewObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.ObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.UpdateObjectDataDto;
import ru.nabokov.dataservice.model.ObjectData;

import java.util.List;

public interface ObjectDataService {

    ObjectDataDto save(NewObjectDataDto objectDataDto);

    ObjectDataDto update(UpdateObjectDataDto objectDataDto);

    ObjectDataDto get(Long id);

    List<ObjectDataDto> getAll(Long typeId);

    String delete(Long id);
}
