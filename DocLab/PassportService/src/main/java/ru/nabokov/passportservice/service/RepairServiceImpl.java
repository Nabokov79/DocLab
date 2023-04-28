package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.RepairMapper;
import ru.nabokov.passportservice.model.Repair;
import ru.nabokov.passportservice.repository.RepairRepository;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repository;
    private final RepairMapper mapper;
    private final PassportClient client;

    @Override
    public RepairDto save(NewRepairDto repairDto) {
        return setValues(repairDto.getObjectDataId(),
                repairDto.getOrganizationId(),
                repository.save(mapper.mapToNewRepair(repairDto)));
    }

    @Override
    public RepairDto update(UpdateRepairDto repairDto) {
        if (repository.existsById(repairDto.getId())) {
            throw new NotFoundException(String.format("repair with id=%s not found for update", repairDto.getId()));
        }
        return setValues(repairDto.getObjectDataId(),
                repairDto.getOrganizationId(),
                repository.save(mapper.mapToUpdateRepair(repairDto)));
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException(String.format("repair with id=%s not found for delete",id));
    }

    private RepairDto setValues(Long objectDataId, Long organizationId, Repair repair) {
        RepairDto repairDto =  mapper.mapToRepairDto(repair);
        repairDto.setObjectData(client.getObjectData(objectDataId));
        repairDto.setOrganization(client.getOrganization(organizationId));
        return  repairDto;
    }
}
