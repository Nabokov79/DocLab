package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.BeltMapper;
import ru.nabokov.passportservice.model.Belt;
import ru.nabokov.passportservice.repository.BeltRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeltServiceImpl implements BeltService {

    private final BeltRepository repository;
    private final BeltMapper mapper;

    @Override
    public List<BeltDto> save(List<NewBeltDto> beltsDto) {
        List<Belt> belts = mapper.mapToNewBelts(beltsDto);
        return mapper.mapToBeltsDto(repository.saveAll(belts));
    }

    @Override
    public List<BeltDto> update(List<UpdateBeltDto> beltsDto) {
        validateIds( beltsDto.stream().map(UpdateBeltDto::getId).toList());
        List<Belt> belts = mapper.mapToUpdateBelts(beltsDto);
        return mapper.mapToBeltsDto(repository.saveAll(belts));
    }

    @Override
    public List<BeltDto> getAll(Integer volume) {
        List<Belt> belts;
        if (volume != null) {
            belts = repository.findAllByVolume(volume);
        } else {
            belts = repository.findAllBottoms();
        }
        if (belts.isEmpty()) {
            throw new NotFoundException(String.format("belts not found, bottoms=%s", belts));
        }
        return mapper.mapToBeltsDto(belts);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException(String.format("belt with id = %s not found for delete", id));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Belt> belts = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Belt::getId, b -> b));
        if (belts.size() != ids.size() || belts.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(belts.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("belts with ids= %s not found", ids));
        }
    }
}
