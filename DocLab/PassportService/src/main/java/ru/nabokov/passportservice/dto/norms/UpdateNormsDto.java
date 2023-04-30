package ru.nabokov.passportservice.dto.norms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения норм брака объекта обследования")
public class UpdateNormsDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    @Schema(description = "Нормы брака днищ емкостей")
    private List<UpdateBottomDto> bottoms;
    @Schema(description = "Нормы брака поясов(корпусов) емкостей")
    private List<UpdateBeltDto> belts;
    @Schema(description = "Нормы брака елементов трубопроводов(мазутопроводов)")
    private List<UpdatePipelineNormDto> pipelineNorms;
}
