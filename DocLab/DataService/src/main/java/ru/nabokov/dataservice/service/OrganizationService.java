package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.organization.NewOrganizationDto;
import ru.nabokov.dataservice.dto.organization.OrganizationDto;
import ru.nabokov.dataservice.dto.organization.UpdateOrganizationDto;
import java.util.List;

public interface OrganizationService {

    OrganizationDto save(NewOrganizationDto organizationDto);

    OrganizationDto update(UpdateOrganizationDto organizationDto);

    OrganizationDto get(Long id);

    List<OrganizationDto> getAll(String ids);

    String delete(Long id);
}
