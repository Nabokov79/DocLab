package ru.nabokov.dataservice.dto.reportData;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Application;
import ru.nabokov.dataservice.model.Employee;
import ru.nabokov.dataservice.model.ObjectData;
import ru.nabokov.dataservice.model.Status;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Информация о отчетной документации")
public class ReportDataDto {

    @Schema(description = "Индентификатор")
    private long id;
    @Schema(description = "Объект обследования")
    private ObjectData objectData;
    @Schema(description = "Сотрудник составивший отчет")
    private Employee employee;
    @Schema(description = "Время начала работы над отчетной документацией")
    private LocalDateTime startTime;
    @Schema(description = "Время окончания работы над отчетной документацией")
    private LocalDateTime endTime;
    @Schema(description = "Номер документа")
    private Integer number;
    @Schema(description = "Заголовок титульного листа документа")
    private String title;
    @Schema(description = "Статус документа")
    private Status status;
    @Schema(description = "Ссылка на место хранения документа")
    private String linkReport;
    @Schema(description = "Ссылка на место хранения приложения к документу")
    private String linkPlan;
}
