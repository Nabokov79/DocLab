package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.model.Belt;

import java.util.List;

public interface BeltService {

    List<Belt> save(Long typeId, List<NewBeltDto> beltsDto);

    List<Belt> update(Long typeId, List<UpdateBeltDto> beltsDto);

    List<Belt> getAll(Integer volume, Long typeId);
}
