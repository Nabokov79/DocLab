package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.type.NewTypeDto;
import ru.nabokov.dataservice.dto.type.TypeDto;
import ru.nabokov.dataservice.dto.type.UpdateTypeDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.TypeMapper;
import ru.nabokov.dataservice.model.Type;
import ru.nabokov.dataservice.repository.TypeRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository repository;
    private final TypeMapper mapper;

    @Override
    public TypeDto save(NewTypeDto typeDto) {
        if (repository.existsByName(typeDto.getName())) {
            throw new BadRequestException(String.format("type=%s found.", typeDto.getName()));
        }
        Type type = mapper.mapToNewType(typeDto);
        return mapper.mapToTypeDto(repository.save(type));
    }

    @Override
    public TypeDto update(UpdateTypeDto typeDto) {
        if (!repository.existsById(typeDto.getId())) {
            throw new NotFoundException(String.format("type=%s not found for update.", typeDto.getName()));
        }
        Type type = mapper.mapToUpdateType(typeDto);
        return mapper.mapToTypeDto(repository.save(type));
    }

    @Override
    public TypeDto get(Long id) {
        return mapper.mapToTypeDto(repository.findById(id)
                             .orElseThrow(() -> new NotFoundException(String.format("Type with id=%s not found", id))));
    }

    @Override
    public List<TypeDto> getAll() {
        return mapper.mapToTypesDto(repository.findAll());
    }
}
