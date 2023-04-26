package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.objectData.NewObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.ObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.UpdateObjectDataDto;
import ru.nabokov.dataservice.model.ObjectData;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectDataMapper {

    ObjectData mapToNewObjectData(NewObjectDataDto objectDataDto);

    ObjectData mapToUpdateObjectData(UpdateObjectDataDto objectDataDto);

    ObjectDataDto mapToObjectDataDto(ObjectData objectData);

    List<ObjectDataDto> mapToObjectsDataDto(List<ObjectData> objectsData);
}
