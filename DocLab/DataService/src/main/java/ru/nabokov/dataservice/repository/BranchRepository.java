package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
