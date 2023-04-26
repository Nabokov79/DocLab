package ru.nabokov.dataservice.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.reportData.Param;
import ru.nabokov.dataservice.dto.reportData.ReportDataDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.mapper.ReportDataMapper;
import ru.nabokov.dataservice.model.*;
import ru.nabokov.dataservice.repository.ReportDataRepository;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

@Service
@RequiredArgsConstructor
public class ReportDataServiceImpl implements ReportDataService {

    private final ReportDataRepository repository;
    private final ReportDataMapper mapper;
    private final EntityManager entityManager;

    @Override
    public List<ReportDataDto> getAll(Param param) {
        QReportData reportData = QReportData.reportData;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<ReportData> query = qf.from(reportData)
                                       .select(reportData)
                                       .where(getPredicate(param));
        return mapper.mapToReportsDataDto(query.fetch());
    }

    @Override
    public void create(LocalDate primaryData, ObjectData objectData) {
        ReportData report = new ReportData();
        report.setObjectData(objectData);
        report.setStatus(Status.WAITING);
        report.setNumber(getMaxNumber() + 1);
        repository.save(report);
    }

    private Integer getMaxNumber() {
        LocalDate now = LocalDate.now();
        LocalDate firstDay = now.with(firstDayOfYear());
        LocalDate lastDay = now.with(lastDayOfYear());
        QReportData reportData = QReportData.reportData;
        return new JPAQueryFactory(entityManager).from(reportData)
                .select(reportData.number.max())
                .where(QReportData.reportData.primaryData.before(firstDay)
                        .and(QReportData.reportData.primaryData.before(lastDay)))
                .fetchOne();
    }

    private BooleanBuilder getPredicate(Param param) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (param.getObjectDataId() != null) {
            booleanBuilder.and(QReportData.reportData.objectData.id.eq(param.getObjectDataId()));
        }
        if (param.getEmployeeId() != null) {
            booleanBuilder.and(QReportData.reportData.employee.id.eq(param.getEmployeeId()));
        }
        if (param.getAddressId() != null) {
            booleanBuilder.and(QReportData.reportData.objectData.building.address.id.eq(param.getAddressId()));
        }
        if (param.getNumber() != null) {
            booleanBuilder.and(QReportData.reportData.number.eq(param.getNumber()));
        }
        if (param.getStartDate() != null) {
            booleanBuilder.and(QReportData.reportData.endTime.before(param.getStartDate().minusDays(1)));
        }
        if (param.getEndDate() != null) {
            booleanBuilder.and(QReportData.reportData.endTime.after(param.getEndDate().plusDays(1)));
        }
        if (param.getStatus() != null) {
            Status status = Status.from(param.getStatus())
                    .orElseThrow(() -> new BadRequestException("Unknown type object: " + param.getStatus()));
            booleanBuilder.and(QReportData.reportData.status.eq(status));
        }
        return booleanBuilder;
    }
}
