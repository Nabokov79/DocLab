package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;

public interface SurveyService {

    SurveyDto save(NewSurveyDto surveyDto);

    SurveyDto update(UpdateSurveyDto surveyDto);

    void delete(Long surId);
}
