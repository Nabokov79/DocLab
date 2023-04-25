package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.mounting.MountingDto;
import ru.nabokov.dataservice.dto.mounting.NewMountingDto;
import ru.nabokov.dataservice.dto.mounting.UpdateMountingDto;
import java.util.List;

public interface MountingService {

    MountingDto save(NewMountingDto mountingDto);

    MountingDto update(UpdateMountingDto mountingDto);

    List<MountingDto> getAll();

    String delete(Long id);
}
