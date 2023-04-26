package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.type.NewTypeDto;
import ru.nabokov.dataservice.dto.type.TypeDto;
import ru.nabokov.dataservice.dto.type.UpdateTypeDto;
import ru.nabokov.dataservice.model.Type;

import java.util.List;

public interface TypeService {

    TypeDto save(NewTypeDto typeDto);

    TypeDto update(UpdateTypeDto typeDto);

    Type get(Long id);

    List<TypeDto> getAll();
}
