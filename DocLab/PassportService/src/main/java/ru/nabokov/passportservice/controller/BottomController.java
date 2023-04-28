package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.bottom.BottomDto;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.service.BottomService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/bottoms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Днище бака",
        description="API для работы с данными днища бака")
public class BottomController {

    private final BottomService service;

    @Operation(summary = "Добавление новых данных днища бака")
    @PostMapping
    public ResponseEntity<List<BottomDto>> save(@RequestBody @Valid List<NewBottomDto> bottomsDto) {
        return ResponseEntity.ok().body(service.save(bottomsDto));
    }

    @Operation(summary = "Изменение данных днища бака")
    @PatchMapping
    public ResponseEntity<List<BottomDto>> update(@RequestBody @Valid List<UpdateBottomDto> bottomsDto) {
        return ResponseEntity.ok().body(service.update(bottomsDto));
    }

    @Operation(summary = "Получение данных днища бака")
    @GetMapping
    public ResponseEntity<List<BottomDto>> getAll(@RequestParam(required = false) @Parameter(description = "Объем бака") Integer volume) {
        return ResponseEntity.ok().body(service.getAll(volume));
    }

    @Operation(summary = "Удаление значений днища бака по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok( "Значения удалены.");
    }
}
