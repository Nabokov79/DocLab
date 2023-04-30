package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.model.Characteristic;
import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.CharacteristicMapper;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.repository.CharacteristicRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {

    private final CharacteristicRepository repository;
    private final CharacteristicMapper mapper;

    @Override
    public List<Characteristic> save(Passport passport, List<NewCharacteristicDto> characteristicsDto) {
        if (repository.existsAllByPassport(passport)) {
            throw new BadRequestException(String.format("Characteristic for passport=%s found", passport));
        }
        List<Characteristic> characteristics = mapper.mapFromNewCharacteristics(characteristicsDto);
        for (Characteristic characteristic : characteristics) {
            characteristic.setPassport(passport);
        }
        return repository.saveAll(characteristics);
    }

    @Override
    public List<Characteristic> update(Passport passport, List<UpdateCharacteristicDto> characteristicsDto) {
        validateIds(characteristicsDto.stream().map(UpdateCharacteristicDto::getId).toList());
        List<Characteristic> characteristics = mapper.mapFromUpdateCharacteristics(characteristicsDto);
        for (Characteristic characteristic : characteristics) {
            characteristic.setPassport(passport);
        }
        return repository.saveAll(characteristics);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Characteristic> characteristics = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Characteristic::getId, d -> d));
        if (characteristics.size() != ids.size() ||  characteristics.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(characteristics.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("characteristics with ids= %s not found", ids));
        }
    }
}
