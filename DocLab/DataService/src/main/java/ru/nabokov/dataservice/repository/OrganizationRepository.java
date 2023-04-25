package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    boolean existsByName(String name);
}
