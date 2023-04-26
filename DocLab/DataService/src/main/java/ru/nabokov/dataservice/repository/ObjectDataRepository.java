package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.ObjectData;
import ru.nabokov.dataservice.model.Type;

import java.util.Set;

public interface ObjectDataRepository extends JpaRepository<ObjectData, Long> {

    Set<ObjectData> findAllByType(Type type);
}
