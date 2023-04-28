package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.model.Passport;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport mapFromNewPassportDto(NewPassportDto passportDto);

    Passport mapFromUpdatePassportDto(UpdatePassportDto passportDto);

    PassportDto mapToPassportDto(Passport passport);

    List<PassportDto> mapToPassportDto(List<Passport> passports);

    TankPassportDto mapToTankPassportDto(Passport passport);

    PipelinePassportDto mapToPipelinePassportDto(Passport passport);

    OilPipelinePassportDto mapToOilPipelinePassportDto(Passport passport);

    FilterPassportDto mapToFilterPassportDto(Passport passport);

    BoilerPassportDto mapToBoilerPassportDto(Passport passport);
}
