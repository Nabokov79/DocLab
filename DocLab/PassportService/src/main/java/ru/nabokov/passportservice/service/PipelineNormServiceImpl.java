package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.pipelinenorm.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.PipelineNormDto;
import ru.nabokov.passportservice.dto.pipelinenorm.UpdatePipelineNormDto;
import ru.nabokov.passportservice.dto.client.TypeDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
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
    private final PassportClient client;
    private final PipelineNormMapper mapper;

    @Override
    public List<PipelineNormDto> save(List<NewPipelineNormDto> pipesDto) {
        return setType(pipesDto.stream().map(NewPipelineNormDto::getTypeId).distinct().toList(),
                       mapper.mapToPipelineNormDto(repository.saveAll(mapper.mapToNewPipelineNorm(pipesDto))));
    }

    @Override
    public List<PipelineNormDto> update(List<UpdatePipelineNormDto> pipesDto) {
        validateIds(pipesDto.stream().map(UpdatePipelineNormDto:: getId).toList());
        return setType(pipesDto.stream().map(UpdatePipelineNormDto::getTypeId).distinct().toList(),
                mapper.mapToPipelineNormDto(repository.saveAll(mapper.mapToUpdatePipelineNorm(pipesDto))));
    }

    @Override
    public List<PipelineNormDto> getAll(Long typeId) {
        return mapper.mapToPipelineNormDto(repository.findAllByTypeId(typeId));
    }

    @Override
    public void delete(Long staId) {
        if (repository.existsById(staId)) {
            repository.deleteById(staId);
        }
        throw new NotFoundException(String.format("standard and norm pipe with id=%s not found for delete.", staId));
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

    private List<PipelineNormDto> setType(List<Long> ids, List<PipelineNormDto> pipelineNorms) {
        if (ids.size() != 1) {
            throw new BadRequestException(
                    String.format("number of object types cannot exceed or be less than one, ids=%s", ids));
        }
        TypeDto type = client.getType(ids.get(0));
        for (PipelineNormDto norm : pipelineNorms) {
            norm.setType(type);
        }
        return pipelineNorms;
    }
}
