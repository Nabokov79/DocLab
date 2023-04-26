package ru.nabokov.dataservice.dto.building;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Address;

@Setter
@Getter
@AllArgsConstructor
public class BuildingDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    private Address address;
    @Schema(description = "Тип строения")
    private String building;
    @Schema(description = "Филиал")
    private String branch;
    @Schema(description = "Имя котельной")
    private String login;
}
