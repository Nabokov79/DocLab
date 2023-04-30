package ru.nabokov.passportservice.dto.norms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные норм для выявления брака объекта обследования")
public class NewNormsDto {

    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    @Schema(description = "Нормы брака днищ емкостей")
    private List<NewBottomDto> bottoms;
    @Schema(description = "Нормы брака поясов(корпусов) емкостей")
    private List<NewBeltDto>  belts;
    @Schema(description = "Нормы брака елементов трубопроводов(мазутопроводов)")
    private List<NewPipelineNormDto> pipelineNorms;
}
