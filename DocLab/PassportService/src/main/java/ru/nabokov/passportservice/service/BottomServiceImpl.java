package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.BottomMapper;
import ru.nabokov.passportservice.model.Bottom;
import ru.nabokov.passportservice.repository.BottomRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottomServiceImpl implements BottomService {

    private final BottomRepository repository;
    private final BottomMapper mapper;

    @Override
    public List<Bottom> save(Long typeId, List<NewBottomDto> bottomsDto) {
        List<Bottom> bottoms = mapper.mapToNewBottoms(bottomsDto);
        for (Bottom bottom : bottoms) {
            bottom.setTypeId(typeId);
        }
        return repository.saveAll(bottoms);
    }

    @Override
    public List<Bottom> update(Long typeId, List<UpdateBottomDto> bottomsDto) {
        validateIds(bottomsDto.stream().map(UpdateBottomDto::getId).toList());
        List<Bottom> bottoms = mapper.mapToUpdateBottoms(bottomsDto);
        for (Bottom bottom : bottoms) {
            bottom.setTypeId(typeId);
        }
        return repository.saveAll(bottoms);
    }

    @Override
    public List<Bottom> getAll(Integer volume, Long typeId) {
        List<Bottom> bottoms;
        if (volume != null) {
             bottoms = repository.findAllByVolumeAndTypeId(volume, typeId);
        } else {
            bottoms = repository.findAllBottoms();
        }
        return bottoms;
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Bottom> bottoms = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Bottom::getId, d -> d));
        if (bottoms.size() != ids.size() || bottoms.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(bottoms.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("bottoms with ids= %s not found", ids));
        }
    }
}
