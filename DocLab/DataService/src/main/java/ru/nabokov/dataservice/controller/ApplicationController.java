package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.application.ApplicationDto;
import ru.nabokov.dataservice.dto.application.ApplicationSearchParam;
import ru.nabokov.dataservice.dto.application.NewApplicationDto;
import ru.nabokov.dataservice.dto.application.UpdateApplicationDto;
import ru.nabokov.dataservice.service.ApplicationService;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/applications",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Заявка",
        description="API для работы с данными заявки")
public class ApplicationController {

    private final ApplicationService service;

    @Operation(summary = "Добавление данных заявки")
    @PostMapping
    public ResponseEntity<ApplicationDto> save(@RequestBody
                                               @Parameter(description = "Заявка") NewApplicationDto applicationDto) {
        return ResponseEntity.ok().body(service.save(applicationDto));
    }

    @Operation(summary = "Изменение данных заявки")
    @PatchMapping
    public ResponseEntity<ApplicationDto> update(@RequestBody
                                          @Parameter(description = "Заявка") UpdateApplicationDto applicationDto) {
        return ResponseEntity.ok().body(service.update(applicationDto));
    }

    @Operation(summary = "Получение данных авторов проектов")
    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAll (
               @RequestParam(value = "addressId", required = false)
               @Parameter(description = "Индентификатор адреса") Long addressId,
               @RequestParam(value = "startDate", required = false)
               @Parameter(description = "Дата начала периода, за который требуется выдать заявки") LocalDate startDate,
               @RequestParam(value = "endDate", required = false)
               @Parameter(description = "Дата окончания периода, за который требуется выдать заявки") LocalDate endDate,
               @RequestParam(value = "report", required = false)
               @Parameter(description = "Указание получить отчеты") Boolean report,
               @RequestParam(value = "protocol", required = false)
               @Parameter(description = "Указание получить протоколы") Boolean protocol,
               @RequestParam(value = "dataId", required = false)
               @Parameter(description = "Индентификатор объекта оследования") Long typeId) {
        ApplicationSearchParam param = new ApplicationSearchParam(addressId, startDate, endDate, report, protocol, typeId);
        return ResponseEntity.ok().body(service.getAll(param));
    }
}
