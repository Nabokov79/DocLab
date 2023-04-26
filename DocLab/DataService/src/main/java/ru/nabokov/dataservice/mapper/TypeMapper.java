package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.type.NewTypeDto;
import ru.nabokov.dataservice.dto.type.TypeDto;
import ru.nabokov.dataservice.dto.type.UpdateTypeDto;
import ru.nabokov.dataservice.model.Type;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    Type mapToNewType(NewTypeDto typeDto);

    TypeDto mapToTypeDto(Type type);

    Type mapToUpdateType(UpdateTypeDto typeDto);

    List<TypeDto> mapToTypesDto(List<Type> types);
}
