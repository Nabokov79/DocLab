package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

    boolean existsByName(String name);
}
