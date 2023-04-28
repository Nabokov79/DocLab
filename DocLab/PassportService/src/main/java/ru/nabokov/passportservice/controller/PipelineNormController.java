package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.PipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;
import ru.nabokov.passportservice.service.PipelineNormService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/pipelines/norms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Типоразмеры и нормы браковки трубопровода",
        description="API для работы с данными типоразмеров и норм браковки трубопровода")
public class PipelineNormController {

    private final PipelineNormService service;

    @Operation(summary = "Добавление новых типоразмеров и норм браковки")
    @PostMapping
    public ResponseEntity<List<PipelineNormDto>> save(
            @RequestBody
            @Parameter(description = "Типоразмеры и нормы браковки") List<NewPipelineNormDto> pipesDto) {
        return ResponseEntity.ok().body(service.save(pipesDto));
    }

    @Operation(summary = "Изменение информации о типоразмерах и норм браковки")
    @PatchMapping
    public ResponseEntity<List<PipelineNormDto>> update(
            @RequestBody
            @Parameter(description = "Типоразмеры и нормы браковки") List<UpdatePipelineNormDto> pipesDto) {
        return ResponseEntity.ok().body(service.update(pipesDto));
    }

    @Operation(summary = "Получение данных всех типоразмеров и норм браковки по типу трубопровода")
    @GetMapping
    public ResponseEntity<List<PipelineNormDto>> getAll(
            @RequestParam @Parameter(description = "Индентификатор назначения трубопровода") Long typeId) {
        return ResponseEntity.ok().body(service.getAll(typeId));
    }

    @Operation(summary = "Удаление данных типоразмера и нормы браковки")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable @Parameter(description = "Индентификатор типоразмера и нормы браковки") Long id) {
        service.delete(id);
        return ResponseEntity.ok( "Значения удалены.");
    }
}
