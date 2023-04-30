package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.PipelineNormMapper;
import ru.nabokov.passportservice.model.PipelineNorm;
import ru.nabokov.passportservice.repository.PipelineNormRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PipelineNormServiceImpl implements PipelineNormService {

    private final PipelineNormRepository repository;
    private final PipelineNormMapper mapper;

    @Override
    public List<PipelineNorm> save(Long typeId, List<NewPipelineNormDto> pipesDto) {
        List<PipelineNorm> pipelineNorms = mapper.mapToNewPipelineNorm(pipesDto);
        for (PipelineNorm norm : pipelineNorms) {
            norm.setTypeId(typeId);
        }
        return repository.saveAll(pipelineNorms);
    }

    @Override
    public List<PipelineNorm> update(Long typeId, List<UpdatePipelineNormDto> pipesDto) {
        validateIds(pipesDto.stream().map(UpdatePipelineNormDto:: getId).toList());
        List<PipelineNorm> pipelineNorms = mapper.mapToUpdatePipelineNorm(pipesDto);
        for (PipelineNorm norm : pipelineNorms) {
            norm.setTypeId(typeId);
        }
        return repository.saveAll(pipelineNorms);
    }

    @Override
    public List<PipelineNorm> getAll(Long typeId) {
        return repository.findAllByTypeId(typeId);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, PipelineNorm> pipelineNorms = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(PipelineNorm::getId, d -> d));
        if (pipelineNorms.size() != ids.size() ||  pipelineNorms.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(pipelineNorms.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("pipeline norms with ids= %s not found", ids));
        }
    }
}
