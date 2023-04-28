package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Protection;

public interface ProtectionRepository extends JpaRepository<Protection, Long> {
}
