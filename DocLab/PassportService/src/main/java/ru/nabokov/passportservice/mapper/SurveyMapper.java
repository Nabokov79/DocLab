package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.model.Survey;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    List<Survey> mapToNewSurveys(List<NewSurveyDto> surveysDto);

    SurveyDto mapToSurveysDto(Survey survey);

    List<Survey> mapToUpdateSurveys(List<UpdateSurveyDto> surveysDto);
}
