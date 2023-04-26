package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.license.LicenseDto;
import ru.nabokov.dataservice.dto.license.NewLicenseDto;
import ru.nabokov.dataservice.dto.license.UpdateLicenseDto;
import java.util.List;

public interface LicenseService {

    LicenseDto save(NewLicenseDto licenseDto);

    LicenseDto update(UpdateLicenseDto licenseDto);

    LicenseDto get(Long id);

    List<LicenseDto> getAll();
}
