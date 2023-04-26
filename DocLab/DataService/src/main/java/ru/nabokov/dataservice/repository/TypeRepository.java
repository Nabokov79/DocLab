package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

    boolean existsByName(String name);
}
