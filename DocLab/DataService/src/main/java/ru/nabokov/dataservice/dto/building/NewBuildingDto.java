package ru.nabokov.dataservice.dto.building;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewBuildingDto {

    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Тип строения")
    @NotBlank(message = "building should not be blank")
    private String building;
    @Schema(description = "Филиал")
    @NotBlank(message = "branch should not be blank")
    private String branch;
    @Schema(description = "Имя котельной")
    private String login;
}
