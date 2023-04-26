package ru.nabokov.dataservice.dto.objectData;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Building;
import ru.nabokov.dataservice.model.Type;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные объекта")
public class ObjectDataDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип объекта")
    private Type type;
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
    @Schema(description = "Данные о строении")
    private Building building;
}
