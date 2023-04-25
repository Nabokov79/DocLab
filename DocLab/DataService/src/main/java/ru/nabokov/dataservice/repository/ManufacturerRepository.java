package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    boolean existsByName(String name);
}
