package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.employee.EmployeeDto;
import ru.nabokov.dataservice.dto.employee.ShortEmployeeDto;
import ru.nabokov.dataservice.dto.measuringTool.NewEmployeeDto;
import ru.nabokov.dataservice.dto.employee.UpdateEmployeeDto;
import ru.nabokov.dataservice.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee mapToEmployee(NewEmployeeDto employeeDto);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToUpdateEmployee(UpdateEmployeeDto employeeDto);

    ShortEmployeeDto mapToEmployeeShortDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
