package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.employee.EmployeeDto;
import ru.nabokov.dataservice.dto.employee.ShortEmployeeDto;
import ru.nabokov.dataservice.dto.measuringTool.NewEmployeeDto;
import ru.nabokov.dataservice.dto.employee.UpdateEmployeeDto;
import java.util.List;

public interface EmployeeService {

    ShortEmployeeDto save(NewEmployeeDto employeeDto);

    ShortEmployeeDto update(UpdateEmployeeDto employeeDto);

    EmployeeDto get(Long id);

    List<ShortEmployeeDto> getAll();

    void delete(Long id);
}
