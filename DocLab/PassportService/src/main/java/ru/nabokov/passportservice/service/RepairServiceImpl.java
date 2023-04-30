package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.RepairMapper;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.model.Repair;
import ru.nabokov.passportservice.repository.RepairRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repository;
    private final RepairMapper mapper;
    private final PassportClient client;

    @Override
    public List<RepairDto> save(Passport passport, List<NewRepairDto> repairsDto) {
        if (repository.existsAllByPassport(passport)) {
            throw new BadRequestException(String.format("Repairs for passport=%s found", passport));
        }
        return setValues(repairsDto.stream().map(NewRepairDto::getOrganizationId).toString(),
                repository.saveAll(mapper.mapToNewRepairs(repairsDto)));
    }

    @Override
    public List<RepairDto> update(Passport passport, List<UpdateRepairDto> repairsDto) {
        validateIds(repairsDto.stream().map(UpdateRepairDto::getId).toList());
        return setValues(repairsDto.stream().map(UpdateRepairDto::getOrganizationId).toString(),
                repository.saveAll(mapper.mapToUpdateRepairs(repairsDto)));
    }

    private List<RepairDto> setValues(String organizationIds, List<Repair> repair) {
        Map<Long, Repair> repairsDb = repair.stream().collect(Collectors.toMap(Repair::getOrganizationId, r -> r));
        Map<Long, OrganizationDto> organizations = client.getOrganizations(organizationIds)
                .stream().collect(Collectors.toMap(OrganizationDto::getId, o -> o));
        List<RepairDto> repairs = new ArrayList<>();
        for (Long organizationId : repairsDb.keySet()) {
            RepairDto repairDto = mapper.mapToRepairsDto(repairsDb.get(organizationId));
            repairDto.setOrganization(organizations.get(organizationId));
            repairs.add(repairDto);
        }
        return repairs;
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Repair> repairs = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Repair::getId, d -> d));
        if (repairs.size() != ids.size() || repairs.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(repairs.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("repairs with ids= %s not found", ids));
        }
    }
}
