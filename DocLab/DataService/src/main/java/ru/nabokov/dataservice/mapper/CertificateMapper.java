package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.certificate.CertificateDto;
import ru.nabokov.dataservice.dto.certificate.NewCertificateDto;
import ru.nabokov.dataservice.dto.certificate.UpdateCertificateDto;
import ru.nabokov.dataservice.model.Certificate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

    List<CertificateDto> mapToCertificatesDto(List<Certificate> certificates);

    Certificate mapToCertificate(NewCertificateDto newCertificateDto);

    Certificate mapToUpdateCertificate(UpdateCertificateDto updateCertificateDto);
}
