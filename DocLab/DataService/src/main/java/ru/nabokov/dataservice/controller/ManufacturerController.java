package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.manufacturer.ManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.NewManufacturerDto;
import ru.nabokov.dataservice.dto.manufacturer.UpdateManufacturerDto;
import ru.nabokov.dataservice.service.ManufacturerService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/manufacturers",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Изготовитель",
     description="API для работы с данными завода-изготовителя")
public class ManufacturerController {

    private final ManufacturerService service;

    @Operation(summary = "Добавление данных завода-изготовителя")
    @PostMapping
    public ResponseEntity<ManufacturerDto> save(@RequestBody @Parameter(description = "Завод-изготовитель")
                                                NewManufacturerDto manufacturerDto) {
        return ResponseEntity.ok().body(service.save(manufacturerDto));
    }

    @Operation(summary = "Изменение данных завода-изготовителя")
    @PatchMapping
    public ResponseEntity<ManufacturerDto> update(@RequestBody @Parameter(description = "Завод-изготовитель")
                                                  UpdateManufacturerDto manufacturerDto) {
        return ResponseEntity.ok().body(service.update(manufacturerDto));
    }

    @Operation(summary = "Получение данных заводов-изготовителей")
    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных завода-изготовителя")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok(service.delete(id) + " - удален.");
    }
}
