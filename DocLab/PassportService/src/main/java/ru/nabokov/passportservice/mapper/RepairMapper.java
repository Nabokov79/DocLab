package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.model.Repair;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RepairMapper {

    List<Repair> mapToNewRepairs(List<NewRepairDto> repairsDto);

    RepairDto mapToRepairsDto(Repair repair);

    List<Repair> mapToUpdateRepairs(List<UpdateRepairDto> repairsDto);
}
