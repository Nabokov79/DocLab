package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.norms.NewNormsDto;
import ru.nabokov.passportservice.dto.norms.NormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateNormsDto;
import java.util.List;

public interface NormsService {

    NormsDto save(NewNormsDto normsDto);

    NormsDto update(UpdateNormsDto normsDto);

    List<ObjectDataDto> getAll(Long typeId);
}
