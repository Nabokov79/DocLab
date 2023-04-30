package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.SurveyMapper;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.model.Survey;
import ru.nabokov.passportservice.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository repository;
    private final PassportClient client;
    private final SurveyMapper mapper;

    @Override
    public List<SurveyDto> save(Passport passport, List<NewSurveyDto> surveysDto) {
        if (repository.existsAllByPassport(passport)) {
            throw new BadRequestException(String.format("Surveys for passport=%s found", passport));
        }
        List<Survey> surveys = mapper.mapToNewSurveys(surveysDto);
        for (Survey survey : surveys) {
            survey.setPassport(passport);
        }
        return setValues(surveysDto.stream().map(NewSurveyDto::getOrganizationId).toString(),
                                                                repository.saveAll(surveys));
    }

    @Override
    public List<SurveyDto> update(Passport passport, List<UpdateSurveyDto> surveysDto) {
        validateIds(surveysDto.stream().map(UpdateSurveyDto::getId).toList());
        List<Survey> surveys = mapper.mapToUpdateSurveys(surveysDto);
        for (Survey survey : surveys) {
            survey.setPassport(passport);
        }
        return setValues(surveysDto.stream().map(UpdateSurveyDto::getOrganizationId).toString(),
                                                                    repository.saveAll(surveys));
    }

    private List<SurveyDto> setValues(String organizationIds, List<Survey> survey) {
        Map<Long, Survey> surveysDb = survey.stream().collect(Collectors.toMap(Survey::getOrganizationId, s -> s));
        Map<Long, OrganizationDto> organizations = client.getOrganizations(organizationIds)
                                                    .stream().collect(Collectors.toMap(OrganizationDto::getId, o -> o));
        List<SurveyDto> surveys = new ArrayList<>();
        for (Long organizationId : surveysDb.keySet()) {
            SurveyDto surveyDto = mapper.mapToSurveysDto(surveysDb.get(organizationId));
            surveyDto.setOrganization(organizations.get(organizationId));
            surveys.add(surveyDto);
        }
        return surveys;
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Survey> surveys = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Survey::getId, d -> d));
        if (surveys.size() != ids.size() || surveys.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(surveys.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("surveys with ids= %s not found", ids));
        }
    }
}
