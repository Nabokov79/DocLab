package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
