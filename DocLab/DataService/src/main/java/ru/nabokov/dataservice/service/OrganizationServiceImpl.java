package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.organization.NewOrganizationDto;
import ru.nabokov.dataservice.dto.organization.OrganizationDto;
import ru.nabokov.dataservice.dto.organization.UpdateOrganizationDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.OrganizationMapper;
import ru.nabokov.dataservice.model.Organization;
import ru.nabokov.dataservice.repository.OrganizationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;

    @Override
    public OrganizationDto save(NewOrganizationDto organizationDto) {
        if (repository.existsByName(organizationDto.getName())) {
            throw new BadRequestException(
                    String.format("organization=%s found.", organizationDto.getName())
            );
        }
        Organization organization = mapper.mapToNewOrganization(organizationDto);
        return mapper.mapToOrganizationDto(repository.save(organization));
    }

    @Override
    public OrganizationDto update(UpdateOrganizationDto organizationDto) {
        if (!repository.existsById(organizationDto.getId())) {
            throw new NotFoundException(
                    String.format("organization=%s not found for update.", organizationDto.getName())
            );
        }
        Organization organization = mapper.mapToUpdateOrganization(organizationDto);
        return mapper.mapToOrganizationDto(repository.save(organization));
    }

    @Override
    public OrganizationDto get(Long id) {
        return mapper.mapToOrganizationDto(repository.findById(id).orElseThrow(() -> new NotFoundException(
                                                   String.format("Organization with id=%S not found for license",id))));
    }

    @Override
    public List<OrganizationDto> getAll(String ids) {
        if (ids != null) {
            return  mapper.mapToOrganizationsDto(
                 new ArrayList<>(repository.findAllByIds(
                      Arrays.stream(ids.split(",")).toList().stream().mapToLong(Long::parseLong).boxed().toList())
                    )
            );
        }
        return mapper.mapToOrganizationsDto(repository.findAll());
    }

    @Override
    public String delete(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format("organization with id=%s not found for delete.", id))
                );
        repository.deleteById(id);
        return organization.getName();
    }
}
