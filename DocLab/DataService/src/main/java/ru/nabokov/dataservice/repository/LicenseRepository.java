package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.License;
import java.time.LocalDate;

public interface LicenseRepository extends JpaRepository<License, Long> {

    boolean existsByDate(LocalDate date);
}
