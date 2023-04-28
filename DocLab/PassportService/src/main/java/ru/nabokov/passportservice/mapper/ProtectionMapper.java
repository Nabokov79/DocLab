package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.protection.NewProtectionsDto;
import ru.nabokov.passportservice.dto.protection.ProtectionsDto;
import ru.nabokov.passportservice.dto.protection.UpdateProtectionsDto;
import ru.nabokov.passportservice.model.Protection;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProtectionMapper {

    Protection mapToNewProtections(NewProtectionsDto protectionsDto);

    ProtectionsDto mapToProtectionsDto(Protection protections);

    Protection mapToUpdateProtections(UpdateProtectionsDto protectionsDto);

    List<ProtectionsDto> mapToProtectionsDto(List<Protection> protections);
}
