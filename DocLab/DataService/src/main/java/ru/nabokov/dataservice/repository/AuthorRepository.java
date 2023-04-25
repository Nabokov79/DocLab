package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByName(String name);
}
