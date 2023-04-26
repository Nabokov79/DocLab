package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.application.ApplicationDto;
import ru.nabokov.dataservice.dto.application.NewApplicationDto;
import ru.nabokov.dataservice.dto.application.UpdateApplicationDto;
import ru.nabokov.dataservice.model.Application;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    Application mapToNewApplication(NewApplicationDto applicationDto);

    ApplicationDto mapToApplicationDto(Application application);

    Application mapToUpdateApplication(UpdateApplicationDto applicationDto);

    List<ApplicationDto> mapToApplicationsDto(List<Application> applications);
}
