package ru.nabokov.passportservice.dto.survey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового обследования")
public class NewSurveyDto {

    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    @Schema(description = "Дата обследования")
    @NotNull(message = "date repair should not be blank")
    private LocalDate date;
    @Schema(description = "Обследование")
    @NotBlank(message = "survey should not be blank")
    private String survey;
    @Schema(description = "Номер отчета обследования")
    @NotBlank(message = "number should not be blank")
    private String number;
    @Schema(description = "Индентификатор организации, проводившей обследование")
    @NotNull(message = "organization id should not be blank")
    private Long organizationId;
}
