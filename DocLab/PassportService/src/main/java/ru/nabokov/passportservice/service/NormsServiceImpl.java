package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.norms.NewNormsDto;
import ru.nabokov.passportservice.dto.norms.NormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateNormsDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.mapper.NormsMapper;
import ru.nabokov.passportservice.model.Belt;
import ru.nabokov.passportservice.model.Bottom;
import ru.nabokov.passportservice.model.Norm;
import ru.nabokov.passportservice.model.PipelineNorm;
import ru.nabokov.passportservice.repository.NormsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NormsServiceImpl implements NormsService {

    private final NormsRepository repository;
    private final NormsMapper mapper;
    private final PassportClient client;
    private final BeltService beltService;
    private final BottomService bottomService;
    private final PipelineNormService pipelineNormService;

    @Override
    public NormsDto save(NewNormsDto normsDto) {
        ObjectDataDto objectData = client.getObjectData(normsDto.getObjectDataId());
        Norm norms = setValues(new Norm(), objectData);
        List<Belt> belts;
        List<Bottom> bottoms;
        List<PipelineNorm> pipelineNorms;
        if (normsDto.getBelts() != null && normsDto.getBottoms() != null) {
            belts = beltService.save(objectData.getType().getId(), normsDto.getBelts());
            bottoms = bottomService.save(objectData.getType().getId(), normsDto.getBottoms());
        } else {
            belts = beltService.getAll(objectData.getVolume(), objectData.getType().getId());
            bottoms = bottomService.getAll(objectData.getVolume(), objectData.getType().getId());
        }
        if (normsDto.getPipelineNorms() != null) {
            pipelineNorms = pipelineNormService.save(objectData.getType().getId(), normsDto.getPipelineNorms());
        } else {
            pipelineNorms = pipelineNormService.getAll(objectData.getType().getId());
        }
        return mapper.mapToNormsDto(repository.save(setNorm(norms,belts, bottoms, pipelineNorms)));
    }

    @Override
    public NormsDto update(UpdateNormsDto normsDto) {
        ObjectDataDto objectData = client.getObjectData(normsDto.getObjectDataId());
        Norm norms = setValues(mapper.mapToUpdateNormsDto(normsDto), objectData);
        List<Belt> belts;
        List<Bottom> bottoms;
        List<PipelineNorm> pipelineNorms;
        if (normsDto.getBelts() != null && normsDto.getBottoms() != null) {
            belts = beltService.update(objectData.getType().getId(), normsDto.getBelts());
            bottoms = bottomService.update(objectData.getType().getId(), normsDto.getBottoms());
        } else {
            belts = beltService.getAll(objectData.getVolume(), objectData.getType().getId());
            bottoms = bottomService.getAll(objectData.getVolume(), objectData.getType().getId());
        }
        if (normsDto.getPipelineNorms() != null) {
            pipelineNorms = pipelineNormService.update(objectData.getType().getId(), normsDto.getPipelineNorms());
        } else {
            pipelineNorms = pipelineNormService.getAll(objectData.getType().getId());
        }
        return mapper.mapToNormsDto(repository.save(setNorm(norms,belts, bottoms, pipelineNorms)));
    }

    @Override
    public List<ObjectDataDto> getAll(Long typeId) {
        return null;
    }

    private Norm setValues(Norm norms, ObjectDataDto objectData) {
        norms.setObjectDataId(objectData.getId());
        norms.setTypeId(objectData.getType().getId());
        return norms;
    }

    private Norm setNorm(Norm norms, List<Belt> belts, List<Bottom> bottoms, List<PipelineNorm> pipelineNorms) {
        if ((belts.isEmpty() && bottoms.isEmpty()) || pipelineNorms.isEmpty()) {
            throw new BadRequestException(String.format("Norms for type with id=%s not found", norms.getTypeId()));
        } else {
            if (!belts.isEmpty() && !bottoms.isEmpty()) {
                norms.setBelts(belts);
                norms.setBottoms(bottoms);
            }
            if (!pipelineNorms.isEmpty()) {
                norms.setPipelineNorms(pipelineNorms);
            }
        }
        return norms;
    }
}
