package ru.nabokov.dataservice.dto.objectData;

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
@Schema(description = "Данные нового объекта")
public class NewObjectDataDto {

    @Schema(description = "Индентификатор типа объекта")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id can only be positive")
    private Long typeId;
    @Schema(description = "Модель")
    private String model;
    @Schema(description = "Стационарный номер")
    private Integer number;
    @Schema(description = "Объем емкости")
    private Integer volume;
    @Schema(description = "Положение в пространстве")
    private String orientation;
    @Schema(description = "Местомоложение на территории")
    private String place;
    @Schema(description = "Индентификатор данных о строении")
    @NotNull(message = "building id should not be blank")
    @Positive(message = "building id can only be positive")
    private Long buildingId;
}
