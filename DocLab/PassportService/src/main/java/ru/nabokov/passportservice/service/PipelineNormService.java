package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.PipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;

import java.util.List;

public interface PipelineNormService {

    List<PipelineNormDto> save(List<NewPipelineNormDto> pipesDto);

    List<PipelineNormDto> update(List<UpdatePipelineNormDto> pipesDto);

    List<PipelineNormDto> getAll(Long typeId);

    void delete(Long id);
}
