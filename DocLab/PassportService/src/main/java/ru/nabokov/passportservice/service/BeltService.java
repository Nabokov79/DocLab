package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import java.util.List;

public interface BeltService {

    List<BeltDto> save(List<NewBeltDto> beltsDto);

    List<BeltDto> update(List<UpdateBeltDto> beltsDto);

    List<BeltDto> getAll(Integer volume);

    void delete(Long id);
}
