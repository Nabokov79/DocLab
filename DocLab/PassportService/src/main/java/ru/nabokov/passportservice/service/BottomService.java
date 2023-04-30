package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.model.Bottom;

import java.util.List;

public interface BottomService {

    List<Bottom> save(Long typeId, List<NewBottomDto> bottomsDto);

    List<Bottom> update(Long typeId, List<UpdateBottomDto> bottomsDto);

    List<Bottom> getAll(Integer volume, Long typeId);
}
