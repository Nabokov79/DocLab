package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    boolean existsAllByPassport(Passport passport);
}
