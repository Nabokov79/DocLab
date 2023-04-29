package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.mapper.PassportMapper;
import ru.nabokov.passportservice.service.PassportService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт объекта обследования",
        description="API для работы с данными паспорта")
public class PassportController {

    private final PassportService service;
    private final PassportMapper mapper;

    @Operation(summary = "Добавление новых данных паспорта")
    @PostMapping
    public ResponseEntity<PassportDto> save(@RequestBody
                                            @Parameter(description = "Данные паспорта") NewPassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<PassportDto> update(@RequestBody
                                            @Parameter(description = "Данные паспорта") UpdatePassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получить паспорт бака")
    @GetMapping("/tank/{id}")
    public ResponseEntity<TankPassportDto> getTankPassport(
                                                    @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(mapper. mapToTankPassportDto(service.get(id)));
    }

    @Operation(summary = "Получить данные паспорта трубопровода")
    @GetMapping("/pipeline/{id}")
    public ResponseEntity<PipelinePassportDto> getPipelinePassport(
                                                    @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(mapper.mapToPipelinePassportDto(service.get(id)));
    }

    @Operation(summary = "Получить данные паспорта мазутопровода")
    @GetMapping("/pipeline/oil/{id}")
    public ResponseEntity<OilPipelinePassportDto> getOilPipelinePassport(
                                                    @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(mapper.mapToOilPipelinePassportDto(service.get(id)));
    }

    @Operation(summary = "Получить данные паспорта фильтра")
    @GetMapping("/filter/{id}")
    public ResponseEntity<FilterPassportDto> getFilterPassport(
                                                    @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(mapper.mapToFilterPassportDto(service.get(id)));
    }

    @Operation(summary = "Получить данные паспорта котла")
    @GetMapping("/boiler/{id}")
    public ResponseEntity<BoilerPassportDto> getBoilerPassportDto(
            @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(mapper.mapToBoilerPassportDto(service.get(id)));
    }

    @Operation(summary = "Получение данные паспортов")
    @GetMapping
    public ResponseEntity<List<PassportDto>> getAll(@RequestParam(required = false)
                                                        @Parameter(description = "Индентификатор типа объекта") Long typeId) {
        return ResponseEntity.ok().body(mapper.mapToPassportDto(service.getAll(typeId)));
    }

    @Operation(summary = "Удаление данные паспорта")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Значения удалены.");
    }
}
