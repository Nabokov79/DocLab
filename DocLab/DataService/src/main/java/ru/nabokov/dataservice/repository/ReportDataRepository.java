package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.nabokov.dataservice.model.ReportData;

public interface ReportDataRepository extends JpaRepository<ReportData, Long>, QuerydslPredicateExecutor<ReportData> {
}
