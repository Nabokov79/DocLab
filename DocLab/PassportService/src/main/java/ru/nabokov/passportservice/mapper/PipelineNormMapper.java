package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;
import ru.nabokov.passportservice.model.PipelineNorm;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PipelineNormMapper {

    List<PipelineNorm> mapToNewPipelineNorm(List<NewPipelineNormDto> pipelineNormsDto);

    List<PipelineNorm> mapToUpdatePipelineNorm(List<UpdatePipelineNormDto> pipelineNormsDto);
}
