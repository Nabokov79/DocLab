package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.measuringTool.MeasuringToolDto;
import ru.nabokov.dataservice.dto.measuringTool.MeasuringToolIds;
import ru.nabokov.dataservice.dto.measuringTool.NewMeasuringToolDto;
import ru.nabokov.dataservice.dto.measuringTool.UpdateMeasuringToolDto;
import ru.nabokov.dataservice.model.MeasuringTool;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MeasuringToolMapper {

    MeasuringTool mapToNewMeasuringTool(NewMeasuringToolDto newMeasuringToolDto);

    MeasuringToolDto mapToMeasuringToolDto(MeasuringTool measuringTools);

    MeasuringTool mapToUpdateMeasuringTool(UpdateMeasuringToolDto measuringToolDto);

    List<MeasuringToolDto> mapToMeasuringToolsDto(List<MeasuringTool> newMeasuringTools);

    MeasuringToolIds mapToNeMeasuringToolValue(NewMeasuringToolDto newMeasuringToolDto);
    MeasuringToolIds mapToUpdateMeasuringToolValue(UpdateMeasuringToolDto measuringToolDto);
}
