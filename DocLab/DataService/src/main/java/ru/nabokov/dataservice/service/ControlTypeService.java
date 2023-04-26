package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.controlType.ControlTypeDto;
import ru.nabokov.dataservice.dto.controlType.NewControlTypeDto;
import ru.nabokov.dataservice.dto.controlType.UpdateControlTypeDto;
import ru.nabokov.dataservice.model.ControlType;

import java.util.List;

public interface ControlTypeService {


    ControlTypeDto save(NewControlTypeDto typeControlDto);

    ControlTypeDto update(UpdateControlTypeDto typeControlDto);

    ControlType get(Long id);

    List<ControlTypeDto> getAll();

    String delete(Long typId);
}
