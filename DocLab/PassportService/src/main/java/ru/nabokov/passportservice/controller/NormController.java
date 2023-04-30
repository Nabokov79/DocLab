package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.norms.NewNormsDto;
import ru.nabokov.passportservice.dto.norms.NormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateNormsDto;
import ru.nabokov.passportservice.service.NormsService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/norms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Нормы выявления брака",
        description="API для работы с нормами выявления брака в объекте обследования")
public class NormController {

    private final NormsService service;


    @Operation(summary = "Добавление новых норм")
    @PostMapping
    public ResponseEntity<NormsDto> save(@RequestBody @Parameter(description = "Нормы") NewNormsDto normsDto) {
        return ResponseEntity.ok().body(service.save(normsDto));
    }

    @Operation(summary = "Изменение данных норм")
    @PatchMapping
    public ResponseEntity<NormsDto> update(@RequestBody @Parameter(description = "Нормы") UpdateNormsDto normsDto) {
        return ResponseEntity.ok().body(service.update(normsDto));
    }

    @Operation(summary = "Получение норм")
    @GetMapping
    public ResponseEntity<List<ObjectDataDto>> getAll(@RequestParam(required = false)
                                               @Parameter(description = "Индентификатор типа объекта") Long typeId) {
        return ResponseEntity.ok().body(service.getAll(typeId));
    }
}
