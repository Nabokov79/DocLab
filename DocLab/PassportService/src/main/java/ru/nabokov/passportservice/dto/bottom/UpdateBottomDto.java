package ru.nabokov.passportservice.dto.bottom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для обновления информации о днище бака")
public class UpdateBottomDto {

    @Schema(description = "Индентификатор ")
    @NotNull(message = "id bottom should not be blank")
    @Positive(message = "id bottom can only be positive")
    private Long id;
    @Schema(description = "Объем бака")
    @NotNull(message = "tank volume should not be blank")
    @Positive(message = " tank volume can only be positive")
    private Integer volume;
    @Schema(description = "Название днища")
    private String name;
    @Schema(description = "Толщина днища")
    @NotNull(message = "thickness bottom should not be blank")
    @Positive(message = "thickness bottom can only be positive")
    private Integer thickness;
    @Schema(description = "Пределная допустимая толщина днища")
    @NotNull(message = "norm bottom should not be blank")
    @Positive(message = "norm bottom can only be positive")
    private Float min;
    @Schema(description = "Окраек днища")
    @NotNull(message = "edge should not be blank")
    private EdgeDto edge;
}
