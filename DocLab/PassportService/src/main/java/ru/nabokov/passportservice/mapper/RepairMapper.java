package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.model.Repair;

@Mapper(componentModel = "spring")
public interface RepairMapper {

    Repair mapToNewRepair(NewRepairDto repairDto);

    RepairDto mapToRepairDto(Repair repair);

    Repair mapToUpdateRepair(UpdateRepairDto repairDto);
}
