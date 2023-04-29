package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.objectData.NewObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.ObjectDataDto;
import ru.nabokov.dataservice.dto.objectData.UpdateObjectDataDto;
import ru.nabokov.dataservice.service.ObjectDataService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/object",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Данные объекта обследования",
        description="API для работы с данными объекта обследования")
public class ObjectDataController {

    private final ObjectDataService service;

    @Operation(summary = "Добавление данных объекта")
    @PostMapping
    public ResponseEntity<ObjectDataDto> save(
                               @RequestBody @Parameter(description = "Данные объекта") NewObjectDataDto objectDataDto) {
        return ResponseEntity.ok().body(service.save(objectDataDto));
    }

    @Operation(summary = "Изменение данных объекта")
    @PatchMapping
    public ResponseEntity<ObjectDataDto> update(
                            @RequestBody @Parameter(description = "Данные объекта") UpdateObjectDataDto objectDataDto) {
        return ResponseEntity.ok().body(service.update(objectDataDto));
    }

    @Operation(summary = "Получение данных объекта")
    @GetMapping("/{id}")
    public ResponseEntity<ObjectDataDto> get(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получение данных объектов")
    @GetMapping
    public ResponseEntity<List<ObjectDataDto>> getAll(
                                                  @RequestParam(required = false)
                                                  @Parameter(description = "Индентификатор типа объекта") Long typeId) {
        return ResponseEntity.ok().body(service.getAll(typeId));
    }

    @Operation(summary = "Удаление данных объекта")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok(service.delete(id) + " - удален.");
    }
}
