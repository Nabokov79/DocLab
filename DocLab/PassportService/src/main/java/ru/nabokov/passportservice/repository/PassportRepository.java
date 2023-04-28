package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

    boolean existsByObjectDataId(Long objectDataId);
}
