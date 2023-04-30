package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.model.Passport;

import java.util.List;

public interface RepairService {

    List<RepairDto> save(Passport passport, List<NewRepairDto> repairsDto);

    List<RepairDto> update(Passport passport, List<UpdateRepairDto> repairDto);
}