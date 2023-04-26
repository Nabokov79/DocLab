package ru.nabokov.dataservice.dto.license;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Organization;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные лицензии")
public class LicenseDto {

    @Schema(description = "Индентификатор лицензии")
    private Long id;
    @Schema(description = "Вид документа")
    private String document;
    @Schema(description = "Организация")
    private Organization organization;
    @Schema(description = "Номер лицензии")
    private String number;
    @Schema(description = "Дата выдачи лицензии")
    private LocalDate date;
}
