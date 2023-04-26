package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByServiceNumber(Integer serviceNumber);
}
