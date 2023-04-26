package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.branch.BranchDto;
import ru.nabokov.dataservice.dto.branch.NewBranchDto;
import ru.nabokov.dataservice.dto.branch.UpdateBranchDto;
import ru.nabokov.dataservice.service.BranchService;

@RestController
@RequestMapping(
        value = "/admin/branch",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Подразделение",
        description="API для работы с данными подразделения")
public class BranchController {

    private final BranchService service;

    @Operation(summary = "Добавление данных лаборатории")
    @PostMapping
    public ResponseEntity<BranchDto> save(
            @RequestBody @Parameter(description = "Подразделение") NewBranchDto branchDto) {
        return ResponseEntity.ok().body(service.save(branchDto));
    }

    @Operation(summary = "Изменение данных лаборатории")
    @PatchMapping
    public ResponseEntity<BranchDto> update(
            @RequestBody @Parameter(description = "Подразделение") UpdateBranchDto branchDto) {
        return ResponseEntity.ok().body(service.update(branchDto));
    }

    @Operation(summary = "Получение данных падразделения")
    @GetMapping("/{id}")
    public ResponseEntity<BranchDto> get(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }
}
