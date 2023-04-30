package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.model.Passport;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport mapFromNewPassportDto(NewPassportDto passportDto);

    Passport mapFromUpdatePassportDto(UpdatePassportDto passportDto);

    PassportDto mapToPassportDto(Passport passport);

    List<ShortPassportDto> mapToShortPassportDto(List<Passport> passports);

}
