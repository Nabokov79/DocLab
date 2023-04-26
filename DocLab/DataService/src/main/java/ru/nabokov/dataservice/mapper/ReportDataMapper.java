package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.reportData.ReportDataDto;
import ru.nabokov.dataservice.model.ReportData;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportDataMapper {

    List<ReportDataDto> mapToReportsDataDto(List<ReportData> reportData);
}
