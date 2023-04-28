package ru.nabokov.passportservice.dto.bottom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные окрайка днища")
public class EdgeDto {

    @Schema(description = "Толщина")
    @NotNull(message = "thickness edge should not be blank")
    @Positive(message = "thickness edge can only be positive")
    private Integer thickness;
    @Schema(description = "Пределная допустимая толщина")
    @NotNull(message = "norm edge should not be blank")
    @Positive(message = "norm edge can only be positive")
    private Float min;
}
