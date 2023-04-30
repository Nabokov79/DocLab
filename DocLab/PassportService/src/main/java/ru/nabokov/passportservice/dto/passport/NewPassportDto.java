package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewPassportDto {

    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<NewCharacteristicDto> characteristics;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<NewRepairDto> repairs;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<NewSurveyDto> surveys;
}
