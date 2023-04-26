package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.MeasuringTool;
import java.util.Set;

public interface MeasuringToolRepository extends JpaRepository<MeasuringTool, Long> {

    Set<MeasuringTool> findAllByEmployeeId(Long employeeId);
}
