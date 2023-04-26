package ru.nabokov.dataservice.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Certificate;
import ru.nabokov.dataservice.model.MeasuringTool;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные о сотруднике")
public class EmployeeDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Имя")
    private String name;
    @Schema(description = "Отчество")
    private String patronymic;
    @Schema(description = "Фамилия")
    private String surname;
    @Schema(description = "Должность")
    private String post;
    @Schema(description = "Табельный номер")
    private Integer serviceNumber;
    @Schema(description = "Список сертификатов сотрудника")
    private List<Certificate> certificate;
    @Schema(description = "Список средств(приборов) закрепленных за сотрудником")
    private List<MeasuringTool> measuringTool;
}
