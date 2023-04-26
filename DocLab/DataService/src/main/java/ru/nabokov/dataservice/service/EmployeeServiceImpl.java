package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.employee.ShortEmployeeDto;
import ru.nabokov.dataservice.dto.measuringTool.NewEmployeeDto;
import ru.nabokov.dataservice.dto.employee.EmployeeDto;
import ru.nabokov.dataservice.dto.employee.UpdateEmployeeDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.EmployeeMapper;
import ru.nabokov.dataservice.model.Employee;
import ru.nabokov.dataservice.model.MeasuringTool;
import ru.nabokov.dataservice.repository.CertificateRepository;
import ru.nabokov.dataservice.repository.EmployeeRepository;
import ru.nabokov.dataservice.repository.MeasuringToolRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final CertificateRepository certificateRepository;
    private final MeasuringToolRepository measuringToolRepository;
    private final EmployeeMapper mapper;

    @Override
    public ShortEmployeeDto save(NewEmployeeDto employeeDto) {
        if (repository.existsByServiceNumber(employeeDto.getServiceNumber())) {
            throw new BadRequestException(String.format("employee=%s found.", employeeDto));
        }
        Employee employee = repository.save(mapper.mapToEmployee(employeeDto));
        return mapper.mapToEmployeeShortDto(employee);
    }

    @Override
    public ShortEmployeeDto update(UpdateEmployeeDto employeeDto) {
        if (!repository.existsById(employeeDto.getId())) {
            throw new NotFoundException(String.format("employee with id=%s not found for update",employeeDto.getId()));
        }
        Employee employee = repository.save(mapper.mapToUpdateEmployee(employeeDto));
        return mapper.mapToEmployeeShortDto(employee);
    }

    @Override
    public EmployeeDto get(Long id) {
        return mapper.mapToEmployeeDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("employee with id=%s was not found", id))));
    }

    @Override
    public List<ShortEmployeeDto> getAll() {
        return repository.findAll().stream().map(mapper::mapToEmployeeShortDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            updateMeasuringTool(id);
            certificateRepository.deleteAllByEmployeeId(id);
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("employee with id = %s not found for delete",id));
    }

    private void updateMeasuringTool(Long id) {
        Set<MeasuringTool> measuringTools = measuringToolRepository.findAllByEmployeeId(id);
        measuringTools.forEach(measuringTool -> measuringTool.setEmployee(null));
        measuringToolRepository.saveAll(measuringTools);
    }
}
