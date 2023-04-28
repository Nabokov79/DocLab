package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.passportservice.dto.DimensionDto;
import ru.nabokov.passportservice.model.Protection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewPassportDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    private Long authorId;
    private String projectNumber;
    private Long manufacturerId;
    private Long mountingId;
    private String manufacture;
    private LocalDate installation;
    private LocalDate operation;
    private LocalDate startPassport;
    private DimensionDto dimension;
    private Float heightPipe;
    private Protection protection;
    private Integer estimatedLife;
    private Integer pressure;
    private String directPressure;
    private String directTemperature;
    private String backPressure;
    private String backTemperature;
    private String temperature;
}
