package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.model.Bottom;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BottomMapper {

    List<Bottom> mapToNewBottoms(List<NewBottomDto> bottomsDto);

    List<Bottom> mapToUpdateBottoms(List<UpdateBottomDto> bottomsDto);
}