package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.organization.NewOrganizationDto;
import ru.nabokov.dataservice.dto.organization.OrganizationDto;
import ru.nabokov.dataservice.dto.organization.UpdateOrganizationDto;
import ru.nabokov.dataservice.service.OrganizationService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/organizations",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Организация",
     description="API для работы с данными организации")
public class OrganizationController {

    private final OrganizationService service;

    @Operation(summary = "Добавление данных организации")
    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody @Parameter(description = "Организация")
                                                NewOrganizationDto organizationDto) {
        return ResponseEntity.ok().body(service.save(organizationDto));
    }

    @Operation(summary = "Изменение данных организации")
    @PatchMapping
    public ResponseEntity<OrganizationDto> update(@RequestBody @Parameter(description = "Организация")
                                                  UpdateOrganizationDto organizationDto) {
        return ResponseEntity.ok().body(service.update(organizationDto));
    }

    @Operation(summary = "Получение данных организаций")
    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных организации")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok(service.delete(id) + " - удален.");
    }
}
