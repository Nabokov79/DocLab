package ru.nabokov.dataservice.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.application.ApplicationDto;
import ru.nabokov.dataservice.dto.application.ApplicationSearchParam;
import ru.nabokov.dataservice.dto.application.NewApplicationDto;
import ru.nabokov.dataservice.dto.application.UpdateApplicationDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.ApplicationMapper;
import ru.nabokov.dataservice.mapper.ObjectDataMapper;
import ru.nabokov.dataservice.mapper.TypeMapper;
import ru.nabokov.dataservice.model.Application;
import ru.nabokov.dataservice.model.QApplication;
import ru.nabokov.dataservice.model.Type;
import ru.nabokov.dataservice.repository.ApplicationRepository;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;
    private final ApplicationMapper mapper;
    private final EntityManager entityManager;
    private final ReportDataService reportDataService;
    private final ObjectDataService objectDataService;
    private final ObjectDataMapper objectDataMapper;
    private final TypeService typeService;
    private final TypeMapper typeMapper;

    @Override
    public ApplicationDto save(NewApplicationDto applicationDto) {
        Application application = mapper.mapToNewApplication(applicationDto);
        application.setObjectData(
                objectDataMapper.mapToObjectData(objectDataService.get(applicationDto.getObjectDataId()))
        );
        repository.save(application);
        reportDataService.create(applicationDto.getPrimaryData(), application.getObjectData());
        return mapper.mapToApplicationDto((application));
    }

    @Override
    public ApplicationDto update(UpdateApplicationDto applicationDto) {
        if (!repository.existsById(applicationDto.getId())) {
            throw new NotFoundException(
                                 String.format("application with id=%s not found for update", applicationDto.getId()));
        }
        Application application = mapper.mapToUpdateApplication(applicationDto);
        application.setObjectData(
                objectDataMapper.mapToObjectData(objectDataService.get(applicationDto.getObjectDataId()))
        );
        return mapper.mapToApplicationDto(repository.save(application));
    }

    @Override
    public List<ApplicationDto> getAll(ApplicationSearchParam param) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(param.getAddressId() != null) {
            booleanBuilder.and(QApplication.application.address.id.eq(param.getAddressId()));
        }
        if(param.getStartDate() != null) {
            booleanBuilder.and(QApplication.application.primaryData.before(param.getStartDate()));
        }
        if(param.getEndDate() != null) {
            booleanBuilder.and(QApplication.application.repeatData.after(param.getEndDate()));
        }
        if(param.getReport() != null) {
            booleanBuilder.and(QApplication.application.report.eq(param.getReport()));
        }
        if(param.getProtocol() != null) {
            booleanBuilder.and(QApplication.application.protocol.eq(param.getProtocol()));
        }
        if(param.getTypeId() != null) {
            Type type = typeMapper.mapToType(typeService.get(param.getTypeId()));
            booleanBuilder.and(QApplication.application.objectData.type.eq(type));
        }
        QApplication application = QApplication.application;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<Application> query = qf.from(application)
                .select(application)
                .where(booleanBuilder);
        return mapper.mapToApplicationsDto(query.fetch());
    }
}