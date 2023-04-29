package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Passport;

import java.util.Set;

public interface PassportRepository extends JpaRepository<Passport, Long> {

    boolean existsByObjectDataId(Long objectDataId);

    Set<Passport> findAllByTypeId(Long typeId);
}
