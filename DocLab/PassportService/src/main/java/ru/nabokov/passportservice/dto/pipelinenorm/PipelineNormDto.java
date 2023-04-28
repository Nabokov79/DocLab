package ru.nabokov.passportservice.dto.pipelinenorm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.client.TypeDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные параметров трубы")
public class PipelineNormDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Назначение трубопровода")
    private TypeDto type;
    @Schema(description = "Диаметр")
    private Integer diameter;
    @Schema(description = "Толщина стенки")
    private Float thickness;
    @Schema(description = "Минимальная допустимая толщина стенки")
    private Float min;
}
