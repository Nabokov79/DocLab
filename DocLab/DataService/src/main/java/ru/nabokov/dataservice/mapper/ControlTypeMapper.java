package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.controlType.ControlTypeDto;
import ru.nabokov.dataservice.dto.controlType.NewControlTypeDto;
import ru.nabokov.dataservice.dto.controlType.UpdateControlTypeDto;
import ru.nabokov.dataservice.model.ControlType;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ControlTypeMapper {

    ControlType mapToNewControlType(NewControlTypeDto typeControlDto);

    ControlTypeDto mapToControlTypeDto(ControlType typeControl);

    ControlType mapToUpdateControlType(UpdateControlTypeDto typeControlDto);

    List<ControlTypeDto> mapToControlTypesDto(List<ControlType> typeControls);
}
