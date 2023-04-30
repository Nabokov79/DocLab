package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.model.Belt;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BeltMapper {

    List<Belt> mapToNewBelts(List<NewBeltDto> beltsDto);

    List<Belt> mapToUpdateBelts(List<UpdateBeltDto> beltDto);
}