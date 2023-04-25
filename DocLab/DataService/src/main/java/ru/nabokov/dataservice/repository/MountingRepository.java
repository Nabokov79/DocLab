package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Mounting;

public interface MountingRepository extends JpaRepository<Mounting, Long> {

    boolean existsByName(String name);
}
