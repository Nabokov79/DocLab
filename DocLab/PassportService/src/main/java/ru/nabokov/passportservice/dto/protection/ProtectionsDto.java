package ru.nabokov.passportservice.dto.protection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные антикоррозионной защиты")
public class ProtectionsDto {

    @Schema(description = "Индентификатор ")
    private Long id;
    @Schema(description = "Объект обследования")
    private ObjectDataDto objectData;
    @Schema(description = "Название")
    private String name;
    @Schema(description = "Дата нанесения на стенки бака")
    private LocalDate date;
    @Schema(description = "Номативный документ")
    private String documentation;
}
