package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.application.ApplicationDto;
import ru.nabokov.dataservice.dto.application.ApplicationSearchParam;
import ru.nabokov.dataservice.dto.application.NewApplicationDto;
import ru.nabokov.dataservice.dto.application.UpdateApplicationDto;
import java.util.List;

public interface ApplicationService {

    ApplicationDto save(NewApplicationDto applicationDto);

   ApplicationDto update(UpdateApplicationDto applicationDto);

   List<ApplicationDto> getAll(ApplicationSearchParam param);
}
