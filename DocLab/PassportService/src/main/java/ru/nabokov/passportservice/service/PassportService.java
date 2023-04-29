package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.model.Passport;
import java.util.List;

public interface PassportService {

    PassportDto save(NewPassportDto passportDto);

    PassportDto update(UpdatePassportDto passportDto);

    Passport get(Long id);

    List<Passport> getAll(Long typeId);

   void delete(Long id);
}
