package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.mounting.MountingDto;
import ru.nabokov.dataservice.dto.mounting.NewMountingDto;
import ru.nabokov.dataservice.dto.mounting.UpdateMountingDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.MountingMapper;
import ru.nabokov.dataservice.model.Mounting;
import ru.nabokov.dataservice.repository.MountingRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MountingServiceImpl implements MountingService {

    private final MountingRepository repository;
    private final MountingMapper mapper;

    @Override
    public MountingDto save(NewMountingDto mountingDto) {
        if (repository.existsByName(mountingDto.getName())) {
            throw new BadRequestException(String.format("mounting=%s found.", mountingDto.getName()));
        }
        Mounting mounting = mapper.mapToNewMounting(mountingDto);
        return mapper.mapToMountingDto(repository.save(mounting));
    }

    @Override
    public MountingDto update(UpdateMountingDto mountingDto) {
        if (!repository.existsById(mountingDto.getId())) {
            throw new NotFoundException(String.format("mounting=%s not found for update.", mountingDto.getName()));
        }
        Mounting mounting = mapper.mapToUpdateMounting(mountingDto);
        return mapper.mapToMountingDto(repository.save(mounting));
    }

    @Override
    public List<MountingDto> getAll() {
        return mapper.mapToMountingsDto(repository.findAll());
    }

    @Override
    public String delete(Long id) {
        Mounting mounting = repository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format("mounting with id=%s not found for delete.", id))
                );
        repository.deleteById(id);
        return mounting.getName();
    }
}
