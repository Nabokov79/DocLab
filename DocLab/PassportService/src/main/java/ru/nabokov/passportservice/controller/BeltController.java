package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.service.BeltService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/belts",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Пояс(стенка) бака",
     description="API для работы с данными пояса(стенки) бака")
public class BeltController {

    private final BeltService service;

    @Operation(summary = "Добавление новых данных поясов бака")
    @PostMapping
    public ResponseEntity<List<BeltDto>> save(@RequestBody
                                              @Parameter(description = "Данные поясов")  List<NewBeltDto> beltsDto) {
        return ResponseEntity.ok().body(service.save(beltsDto));
    }

    @Operation(summary = "Изменение данных пояса(стенки) бака")
    @PatchMapping
    public ResponseEntity<List<BeltDto>> update(@RequestBody
                                               @Parameter(description = "Данные поясов") List<UpdateBeltDto> beltsDto) {
        return ResponseEntity.ok().body(service.update(beltsDto));
    }

    @Operation(summary = "Получение значений поясов(стенки) бака")
    @GetMapping
    public ResponseEntity<List<BeltDto>> getAll(
            @RequestParam(required = false) @Parameter(description = "Объем бака") Integer volume) {
        return ResponseEntity.ok().body(service.getAll(volume));
    }

    @Operation(summary = "Удаление данных стенки")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Значения удалены.");
    }
}
