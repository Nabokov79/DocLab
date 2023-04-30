package ru.nabokov.passportservice.dto.сharacteristic;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Новые паспортные данные объекта обследования")
public class NewCharacteristicDto {

    @Schema(description = "Индентификатор данных шаблона подраздела")
    @NotNull(message = "subheading id should not be blank")
    @Positive(message = "subheading id can only be positive")
    private Long subheadingId;
    @Schema(description = "Данные из паспорта объекта")
    @NotBlank(message = "meaning should not be blank")
    private String meaning;
}
