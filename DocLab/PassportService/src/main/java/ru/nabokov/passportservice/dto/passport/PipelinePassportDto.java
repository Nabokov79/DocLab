package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.client.AuthorDto;
import ru.nabokov.passportservice.dto.client.ManufacturerDto;
import ru.nabokov.passportservice.dto.client.MountingDto;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.model.PipelineNorm;
import ru.nabokov.passportservice.model.Repair;
import ru.nabokov.passportservice.model.Survey;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PipelinePassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Объект обследования")
    private ObjectDataDto objectData;
    @Schema(description = "Автор проекта")
    private AuthorDto author;
    @Schema(description = "Номер проекта")
    private String projectNumber;
    @Schema(description = "Завод-изготовитель бака")
    private ManufacturerDto manufacturer;
    @Schema(description = "Монтажная организация")
    private MountingDto mounting;
    @Schema(description = "Дата монтажа")
    private LocalDate installation;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Список типоразмеров и норм браковки")
    private List<PipelineNorm> pipelineNorms;
    @Schema(description = "Список обследований")
    private List<Survey> surveys;
    @Schema(description = "Список ремонтов трубопровода")
    private List<Repair> repairs;
}
