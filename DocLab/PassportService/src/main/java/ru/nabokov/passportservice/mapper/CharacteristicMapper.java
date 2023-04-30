package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import ru.nabokov.passportservice.model.Characteristic;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacteristicMapper {

    List<Characteristic> mapFromNewCharacteristics(List<NewCharacteristicDto> characteristicsDto);

    List<Characteristic> mapFromUpdateCharacteristics(List<UpdateCharacteristicDto> characteristicsDto);
}
