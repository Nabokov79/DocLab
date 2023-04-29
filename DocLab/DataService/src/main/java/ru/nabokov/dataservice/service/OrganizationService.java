package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.organization.NewOrganizationDto;
import ru.nabokov.dataservice.dto.organization.OrganizationDto;
import ru.nabokov.dataservice.dto.organization.UpdateOrganizationDto;
import ru.nabokov.dataservice.model.Organization;

import java.util.List;

public interface OrganizationService {

    OrganizationDto save(NewOrganizationDto organizationDto);

    OrganizationDto update(UpdateOrganizationDto organizationDto);

    OrganizationDto get(Long id);

    List<OrganizationDto> getAll();

    String delete(Long id);
}
