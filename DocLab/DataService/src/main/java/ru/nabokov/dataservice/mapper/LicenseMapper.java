package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.license.LicenseDto;
import ru.nabokov.dataservice.dto.license.NewLicenseDto;
import ru.nabokov.dataservice.dto.license.UpdateLicenseDto;
import ru.nabokov.dataservice.model.License;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LicenseMapper {

    License mapToNewLicense(NewLicenseDto licenseDto);

    LicenseDto mapToLicenseDto(License license);

    License mapToUpdateLicense(UpdateLicenseDto licenseDto);

    List<LicenseDto> mapToLicensesDto(List<License> licenses);

    License mapToLicense(LicenseDto licenseDto);
}
