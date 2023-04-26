package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
