package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nabokov.dataservice.model.Organization;

import java.util.List;
import java.util.Set;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    boolean existsByName(String name);

    @Query("select o from Organization o where o.id in :ids")
    Set<Organization> findAllByIds(@Param("ids") List<Long> ids);
}
