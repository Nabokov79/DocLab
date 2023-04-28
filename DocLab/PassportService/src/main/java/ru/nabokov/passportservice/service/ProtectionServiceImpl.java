package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.protection.NewProtectionsDto;
import ru.nabokov.passportservice.dto.protection.ProtectionsDto;
import ru.nabokov.passportservice.dto.protection.UpdateProtectionsDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.ProtectionMapper;
import ru.nabokov.passportservice.repository.ProtectionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProtectionServiceImpl implements ProtectionService {

    private final ProtectionRepository repository;
    private final ProtectionMapper mapper;
    private final PassportClient client;

    @Override
    public ProtectionsDto save(NewProtectionsDto protectionsDto) {
        ProtectionsDto protection = mapper.mapToProtectionsDto(
                                    repository.save(mapper.mapToNewProtections(protectionsDto)));
        protection.setObjectData(client.getObjectData(protectionsDto.getObjectDataId()));
        return protection;
    }

    @Override
    public ProtectionsDto update(UpdateProtectionsDto protectionsDto) {
        if (!repository.existsById(protectionsDto.getId())) {
            throw new NotFoundException(
                    String.format("Protections with id=%s not found for update", protectionsDto.getId()));
        }
        ProtectionsDto protection = mapper.mapToProtectionsDto(
                                    repository.save(mapper.mapToUpdateProtections(protectionsDto)));
        protection.setObjectData(client.getObjectData(protectionsDto.getObjectDataId()));
        return protection;
    }

    @Override
    public List<ProtectionsDto> getAll() {
        return mapper.mapToProtectionsDto(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Protection with id=%s not found for delete", id));
    }
}
