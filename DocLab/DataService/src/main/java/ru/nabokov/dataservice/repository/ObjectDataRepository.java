package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nabokov.dataservice.model.ObjectData;
import ru.nabokov.dataservice.model.Type;

import java.util.List;
import java.util.Set;

public interface ObjectDataRepository extends JpaRepository<ObjectData, Long> {

    Set<ObjectData> findAllByType(Type type);

    @Query("select o from ObjectData o where o.id in :ids")
    Set<ObjectData> findAllByIds(@Param("ids") List<Long> ids);
}
