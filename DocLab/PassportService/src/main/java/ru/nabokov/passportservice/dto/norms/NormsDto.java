package ru.nabokov.passportservice.dto.norms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.dto.bottom.BottomDto;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.pipelinenorm.PipelineNormDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class NormsDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Объект обследования")
    private ObjectDataDto objectData;
    @Schema(description = "Нормы брака днищ емкостей")
    private List<BottomDto> bottoms;
    @Schema(description = "Нормы брака поясов(корпусов) емкостей")
    private List<BeltDto> belts;
    @Schema(description = "Нормы брака елементов трубопроводов(мазутопроводов)")
    private List<PipelineNormDto> pipelineNorms;
}
