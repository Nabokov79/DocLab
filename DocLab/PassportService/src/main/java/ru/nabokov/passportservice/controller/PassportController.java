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
    @GetMapping("/{id}")
    public ResponseEntity<PassportDto> get(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получение данные паспортов")
    @GetMapping
    public ResponseEntity<List<ShortPassportDto>> getAll(@RequestParam(required = false)
                                                  @Parameter(description = "Индентификатор типа объекта") Long typeId) {
        return ResponseEntity.ok().body(service.getAll(typeId));
    }

    @Operation(summary = "Удаление данные паспорта")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Значения удалены.");
    }
}
