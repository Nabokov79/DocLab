package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.model.Survey;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    Survey mapToNewSurvey(NewSurveyDto surveyDto);

    SurveyDto mapToSurveyDto(Survey survey);

    Survey mapToUpdateSurvey(UpdateSurveyDto surveyDto);
}
