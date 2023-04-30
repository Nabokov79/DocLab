package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UpdatePassportDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = " id standard and norm pipe should not be blank")
    @Positive(message = "id standard and norm pipe can only be positive")
    private Long id;
    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<UpdateCharacteristicDto> characteristics;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<UpdateRepairDto> repairs;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<UpdateSurveyDto> surveys;
}
