package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Norm;

public interface NormsRepository extends JpaRepository<Norm, Long> {
}
