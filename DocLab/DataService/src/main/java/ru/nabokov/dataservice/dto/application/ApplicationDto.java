package ru.nabokov.dataservice.dto.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Address;
import ru.nabokov.dataservice.model.Employee;
import ru.nabokov.dataservice.model.ObjectData;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ApplicationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    private Address address;
    @Schema(description = "Проводимые работы")
    private String work;
    @Schema(description = "Объект обследования")
    private ObjectData objectData;
    @Schema(description = "Первичное обсдедование")
    private LocalDate primaryData;
    @Schema(description = "Повторное обследование")
    private LocalDate repeatData;
    @Schema(description = "Оформить отчет")
    private Boolean report;
    @Schema(description = "Оформить протокол")
    @NotNull(message = "protocol should not be blank")
    @Column(name = "protocol")
    private Boolean protocol;
    @Schema(description = "Примечание")
    private String note;
    @Schema(description = "Сотрудники, проводившие обследование")
    private List<Employee> employees;
}
