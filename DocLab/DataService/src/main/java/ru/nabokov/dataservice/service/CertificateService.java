package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.certificate.CertificateDto;
import ru.nabokov.dataservice.dto.certificate.NewCertificateDto;
import ru.nabokov.dataservice.dto.certificate.UpdateCertificateDto;
import java.time.LocalDate;
import java.util.List;

public interface CertificateService {

    List<CertificateDto> save(List<NewCertificateDto> newCertificates);

    List<CertificateDto> update(List<UpdateCertificateDto> updateCertificates);

    List<CertificateDto> getAll(Long employeeId, LocalDate date);

    void delete(Long id);
}
