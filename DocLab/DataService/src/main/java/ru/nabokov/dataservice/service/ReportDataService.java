package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.reportData.Param;
import ru.nabokov.dataservice.dto.reportData.ReportDataDto;
import ru.nabokov.dataservice.model.ObjectData;

import java.time.LocalDate;
import java.util.List;

public interface ReportDataService {

    List<ReportDataDto> getAll(Param param);

    void create(LocalDate primaryData, ObjectData objectData);
}
