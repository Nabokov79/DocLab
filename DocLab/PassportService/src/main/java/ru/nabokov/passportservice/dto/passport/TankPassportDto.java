package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.client.AuthorDto;
import ru.nabokov.passportservice.dto.client.ManufacturerDto;
import ru.nabokov.passportservice.dto.client.MountingDto;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.model.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные паспорта бака")
public class TankPassportDto {

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
    @Schema(description = "Габаритные размеры бака")
    private Dimensions dimensions;
    @Schema(description = "Список поясов бака")
    private List<Belt> belts;
    @Schema(description = "Список днища(днищ) бака")
    private List<Bottom> bottoms;
    @Schema(description = "Высота переливной трубы")
    private Float heightPipe;
    @Schema(description = "Антикоррозионная защита")
    private Protection protection;
    @Schema(description = "Список обследований")
    private List<Survey> surveys;
    @Schema(description = "Список ремонтов бака")
    private List<Repair> repairs;
}
