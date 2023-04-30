package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;
import ru.nabokov.passportservice.model.PipelineNorm;

import java.util.List;

public interface PipelineNormService {

    List<PipelineNorm> save(Long typeId, List<NewPipelineNormDto> pipesDto);

    List<PipelineNorm> update(Long typeId, List<UpdatePipelineNormDto> pipesDto);

    List<PipelineNorm> getAll(Long typeId);
}
