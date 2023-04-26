package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.ControlType;

public interface ControlTypeRepository extends JpaRepository<ControlType, Long> {

    boolean existsByName(String name);
}
