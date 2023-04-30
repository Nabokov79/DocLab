package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import ru.nabokov.passportservice.model.Characteristic;
import ru.nabokov.passportservice.model.Passport;

import java.util.List;

public interface CharacteristicService {

    List<Characteristic> save(Passport passport, List<NewCharacteristicDto> characteristicsDto);

    List<Characteristic> update(Passport passport, List<UpdateCharacteristicDto> characteristicDto);
}
