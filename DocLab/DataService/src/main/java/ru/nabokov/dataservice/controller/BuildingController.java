package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.building.BuildingDto;
import ru.nabokov.dataservice.dto.building.NewBuildingDto;
import ru.nabokov.dataservice.dto.building.UpdateBuildingDto;
import ru.nabokov.dataservice.service.BuildingService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/building",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Здание",
        description="API для работы с информацией о зданиях")
public class BuildingController {

    private final BuildingService service;

    @Operation(summary = "Добавление новой информации")
    @PostMapping
    public ResponseEntity<BuildingDto> save(
            @RequestBody @Validated @Parameter(description = "Информация о здании") NewBuildingDto buildingDto) {
        return ResponseEntity.ok().body(service.save(buildingDto));
    }

    @Operation(summary = "Изменение данных")
    @PatchMapping
    public ResponseEntity<BuildingDto> update(
            @RequestBody @Validated @Parameter(description = "Информация о здании") UpdateBuildingDto buildingDto) {
        return ResponseEntity.ok().body(service.update(buildingDto));
    }

    @Operation(summary = "Получение данных")
    @GetMapping
    public ResponseEntity<List<BuildingDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление адреса")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok( "Информация удалена");
    }
}
