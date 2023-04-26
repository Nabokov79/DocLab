package ru.nabokov.dataservice.dto.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о заявки")
public class UpdateApplicationDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id tank passport should not be blank")
    @Positive(message = "id tank passport must be positive")
    private Long id;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Проводимые работы")
    @NotBlank(message = "work id should not be blank")
    private String work;
    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "data id should not be blank")
    @Positive(message = "data id can only be positive")
    private Long objectDataId;
    @Schema(description = "Первичное обсдедование")
    @NotNull(message = "primary should not be blank")
    private LocalDate primaryData;
    @Schema(description = "Повторное обследование")
    private LocalDate repeatData;
    @Schema(description = "Оформить отчет")
    @NotNull(message = "report should not be blank")
    private Boolean report;
    @Schema(description = "Оформить протокол")
    @NotNull(message = "protocol should not be blank")
    private Boolean protocol;
    @Schema(description = "Примечание")
    private String note;
    @Schema(description = "Список индентификаторов сотрудников")
    private List<Long> userIds;
}
