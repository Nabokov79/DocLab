package ru.nabokov.dataservice.dto.objectData;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о объекте")
public class UpdateObjectDataDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "object data id should not be blank")
    @Positive(message = "object data id can only be positive")
    private Long id;
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
