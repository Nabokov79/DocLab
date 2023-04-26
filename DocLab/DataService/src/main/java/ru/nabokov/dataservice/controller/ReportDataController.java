package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.reportData.Param;
import ru.nabokov.dataservice.dto.reportData.ReportDataDto;
import ru.nabokov.dataservice.service.ReportDataService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/report",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Отчетная документация",
        description="API для работы с данными отчетной документации")
public class ReportDataController {

    private final ReportDataService service;

    @Operation(summary = "Получение данных отчетных документов")
    @GetMapping
    public ResponseEntity<List<ReportDataDto>> getAll(
            @RequestParam(value = "objectDataId", required = false)
            @NotNull @Positive @Parameter(description = "Объект обследования") Long objectDataId,
            @RequestParam(value = "employeeId", required = false)
            @NotNull @Positive @Parameter(description = "Сотрудник") Long employeeId,
            @RequestParam(value = "addressId", required = false)
            @NotNull @Positive @Parameter(description = "Адрес") Long addressId,
            @RequestParam(value = "number", required = false)
            @NotNull @Positive @Parameter(description = "Номер документа") Integer number,
            @RequestParam(value = "status", required = false)
            @NotNull @Parameter(description = "Статус документа") String status,
            @RequestParam(value = "startDate", required = false)
            @NotNull
            @Parameter(description = "Дата начала периода, за который требуется выдать отчеты") LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false)
            @NotNull
            @Parameter(description = "Дата окончания периода, за который требуется выдать отчеты") LocalDateTime endDate) {
        Param param = new Param(objectDataId, employeeId, addressId,number, status, startDate, endDate);
        return ResponseEntity.ok().body(service.getAll(param));
    }
}
