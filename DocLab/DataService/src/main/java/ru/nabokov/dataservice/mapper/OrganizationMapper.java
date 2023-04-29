package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.organization.NewOrganizationDto;
import ru.nabokov.dataservice.dto.organization.OrganizationDto;
import ru.nabokov.dataservice.dto.organization.UpdateOrganizationDto;
import ru.nabokov.dataservice.model.Organization;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    Organization mapToNewOrganization(NewOrganizationDto organizationDto);

    OrganizationDto mapToOrganizationDto(Organization organization);

    Organization mapToUpdateOrganization(UpdateOrganizationDto organizationDto);

    List<OrganizationDto> mapToOrganizationsDto(List<Organization> organization);

    Organization mapToOrganization(OrganizationDto organizationDto);
}
