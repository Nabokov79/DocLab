package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.protection.NewProtectionsDto;
import ru.nabokov.passportservice.dto.protection.ProtectionsDto;
import ru.nabokov.passportservice.dto.protection.UpdateProtectionsDto;
import java.util.List;

public interface ProtectionService {

    ProtectionsDto save(NewProtectionsDto protectionsDto);

    ProtectionsDto update(UpdateProtectionsDto protectionsDto);

    List<ProtectionsDto> getAll();

    void delete(Long id);
}
