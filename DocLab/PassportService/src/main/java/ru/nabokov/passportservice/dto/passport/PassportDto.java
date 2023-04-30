package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.model.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Объект обследования")
    private ObjectDataDto objectData;
    @Schema(description = "Характеристики")
    private List<Characteristic> characteristics;
    @Schema(description = "Список проведенных обследований")
    private List<SurveyDto> surveys;
    @Schema(description = "Список выполненных ремонтов")
    private List<RepairDto> repairs;
}
