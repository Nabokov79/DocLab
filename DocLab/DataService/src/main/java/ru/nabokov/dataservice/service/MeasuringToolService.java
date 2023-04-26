package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.measuringTool.MeasuringToolDto;
import ru.nabokov.dataservice.dto.measuringTool.NewMeasuringToolDto;
import ru.nabokov.dataservice.dto.measuringTool.RequestParameters;
import ru.nabokov.dataservice.dto.measuringTool.UpdateMeasuringToolDto;
import java.util.List;

public interface MeasuringToolService {

    MeasuringToolDto save(NewMeasuringToolDto newMeasuringTool);

    MeasuringToolDto update(UpdateMeasuringToolDto updateMeasuringTool);

    List<MeasuringToolDto> getAll(RequestParameters parameters);

    void delete(Long id);
}
