package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.model.Passport;

import java.util.List;

public interface SurveyService {

    List<SurveyDto> save(Passport passport, List<NewSurveyDto> surveysDto);

    List<SurveyDto> update(Passport passport, List<UpdateSurveyDto> surveysDto);
}
