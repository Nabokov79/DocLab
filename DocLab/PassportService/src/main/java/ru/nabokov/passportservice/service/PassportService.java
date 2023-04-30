package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.passport.*;
import java.util.List;

public interface PassportService {

    PassportDto save(NewPassportDto passportDto);

    PassportDto update(UpdatePassportDto passportDto);

    PassportDto get(Long id);

    List<ShortPassportDto> getAll(Long typeId);

   void delete(Long id);
}
