package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.SurveyMapper;
import ru.nabokov.passportservice.model.Survey;
import ru.nabokov.passportservice.repository.SurveyRepository;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository repository;
    private final PassportClient client;
    private final SurveyMapper mapper;

    @Override
    public SurveyDto save(NewSurveyDto surveyDto) {
        return setValues(surveyDto.getObjectDataId(),
                         surveyDto.getOrganizationId(),
                         repository.save(mapper.mapToNewSurvey(surveyDto)));
    }

    @Override
    public SurveyDto update(UpdateSurveyDto surveyDto) {
        if (repository.existsById(surveyDto.getId())) {
            throw new NotFoundException(String.format("survey with id=%s not found for update", surveyDto.getId()));
        }
        return setValues(surveyDto.getObjectDataId(),
                         surveyDto.getOrganizationId(),
                         repository.save(mapper.mapToUpdateSurvey(surveyDto)));
    }

    @Override
    public void delete(Long surId) {
        if (repository.existsById(surId)) {
            repository.deleteById(surId);
        }
        throw new NotFoundException(String.format("survey with id=%s not found for delete", surId));
    }

    private SurveyDto setValues(Long objectDataId, Long organizationId, Survey survey) {
        SurveyDto surveyDto =  mapper.mapToSurveyDto(survey);
        surveyDto.setObjectData(client.getObjectData(objectDataId));
        surveyDto.setOrganization(client.getOrganization(organizationId));
        return surveyDto;
    }
}
