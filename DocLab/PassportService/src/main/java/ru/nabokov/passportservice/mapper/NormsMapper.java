package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.norms.NormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateNormsDto;
import ru.nabokov.passportservice.model.Norm;

@Mapper(componentModel = "spring")
public interface NormsMapper {

    NormsDto mapToNormsDto(Norm norm);

    Norm mapToUpdateNormsDto(UpdateNormsDto normsDto);
}
