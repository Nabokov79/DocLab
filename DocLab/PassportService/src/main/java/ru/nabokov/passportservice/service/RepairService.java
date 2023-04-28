package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;

public interface RepairService {

    RepairDto save(NewRepairDto repairDto);

    RepairDto update(UpdateRepairDto repairDto);

    void delete(Long id);
}
