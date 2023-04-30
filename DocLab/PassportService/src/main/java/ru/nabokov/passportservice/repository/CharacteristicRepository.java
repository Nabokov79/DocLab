package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Characteristic;
import ru.nabokov.passportservice.model.Passport;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {

    boolean existsAllByPassport(Passport passport);
}
