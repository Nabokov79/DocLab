package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.service.RepairService;

@RestController
@RequestMapping(
        value = "/passport/repairs",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Ремонты",
        description="API для работы с данными о проведенных ремонтах")
public class RepairController {

    private final RepairService service;

    @Operation(summary = "Добавление информации о новом ремонте")
    @PostMapping
    public ResponseEntity<RepairDto> save(@RequestBody @Parameter(description = "Ремонт") NewRepairDto repairDto) {
        return ResponseEntity.ok().body(service.save(repairDto));
    }

    @Operation(summary = "Изменение информации о ремонте")
    @PatchMapping
    public ResponseEntity<RepairDto> update(@RequestBody @Parameter(description = "Ремонт") UpdateRepairDto repairDto) {
        return ResponseEntity.ok().body(service.update(repairDto));
    }

    @Operation(summary = "Удаление информации о проведенном ремонте")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор ремонта") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Сведения об ремонте удалены.");
    }
}
