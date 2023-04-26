package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
