package ru.nabokov.passportservice.dto.belt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные параметров пояса(стенки) бака")
public class BeltDto {

    @Schema(description = "Индентификатор ")
    private Long id;
    @Schema(description = "Номер пояса")
    private Integer number;
    @Schema(description = "Толщина пояса")
    private Integer thickness;
    @Schema(description = "Минимальная допустимая толщина пояса")
    private Float min;
    @Schema(description = "Объем бака")
    private Integer volume;

}
