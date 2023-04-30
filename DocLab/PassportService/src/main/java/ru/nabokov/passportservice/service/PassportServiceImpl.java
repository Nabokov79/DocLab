package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.passport.NewPassportDto;
import ru.nabokov.passportservice.dto.passport.ShortPassportDto;
import ru.nabokov.passportservice.dto.passport.PassportDto;
import ru.nabokov.passportservice.dto.passport.UpdatePassportDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.PassportMapper;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.repository.PassportRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;
    private final PassportMapper mapper;
    private final PassportClient client;
    private final CharacteristicService characteristicService;

    @Override
    public PassportDto save(NewPassportDto passportDto) {
        if (repository.existsByObjectDataId(passportDto.getObjectDataId())) {
            throw new BadRequestException((String.format("Passport for object data with id=%s found",
                                                                                       passportDto.getObjectDataId())));
        }
        Passport passport = mapper.mapFromNewPassportDto(passportDto);
        ObjectDataDto objectData = client.getObjectData(passportDto.getObjectDataId());
        passport.setTypeId(objectData.getType().getId());
        PassportDto passportDTO = mapper.mapToPassportDto(repository.save(passport));
        passportDTO.setObjectData(objectData);
        passportDTO.setCharacteristics(characteristicService.save(passport, passportDto.getCharacteristics()));
        return passportDTO;
    }

    @Override
    public PassportDto update(UpdatePassportDto passportDto) {
        if (repository.existsById(passportDto.getId())) {
            throw new NotFoundException((String.format("Passport with id=%s not found for save", passportDto.getId())));
        }
        Passport passport = mapper.mapFromUpdatePassportDto(passportDto);
        ObjectDataDto objectData = client.getObjectData(passportDto.getObjectDataId());
        passport.setTypeId(objectData.getType().getId());
        PassportDto passportDTO = mapper.mapToPassportDto(repository.save(passport));
        passportDTO.setObjectData(objectData);
        return passportDTO;
    }

    @Override
    public PassportDto get(Long id) {
        return mapper.mapToPassportDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Passport with id=%s not found for save", id))));
    }

    @Override
    public List<ShortPassportDto> getAll(Long typeId) {
        List<Passport> passports;
        if (typeId != null) {
            passports = new ArrayList<>(repository.findAllByTypeId(typeId));
        } else {
            passports = repository.findAll();
        }
        if (passports.isEmpty()) {
            throw new NotFoundException(String.format("Passports not found, passports=%s", passports));
        }
        return mapper.mapToShortPassportDto(passports);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Passports with id=%s not found for delete", id));
    }
}
