package ru.nabokov.passportservice.dto.bottom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные параметров днища бака")
public class BottomDto {

    @Schema(description = "Индентификатор ")
    private Long id;
    @Schema(description = "Объем бака")
    private Integer volume;
    @Schema(description = "Толщина днища")
    private Integer thickness;
    @Schema(description = "Пределная допустимая толщина днища")
    private Float min;
    @Schema(description = "Окраек днища")
    private EdgeDto edge;
}
