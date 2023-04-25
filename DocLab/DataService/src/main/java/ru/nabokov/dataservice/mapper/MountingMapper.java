package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.mounting.MountingDto;
import ru.nabokov.dataservice.dto.mounting.NewMountingDto;
import ru.nabokov.dataservice.dto.mounting.UpdateMountingDto;
import ru.nabokov.dataservice.model.Mounting;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MountingMapper {

    Mounting mapToNewMounting(NewMountingDto mountingDto);

    MountingDto mapToMountingDto(Mounting mounting);

    Mounting mapToUpdateMounting(UpdateMountingDto mountingDto);

    List<MountingDto> mapToMountingsDto(List<Mounting> mountings);
}
