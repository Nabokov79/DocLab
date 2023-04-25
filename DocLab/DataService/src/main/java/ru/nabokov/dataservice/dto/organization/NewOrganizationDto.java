package ru.nabokov.dataservice.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новой организации")
public class NewOrganizationDto {

    @Schema(description = "Вид собственности организации")
    @NotBlank(message = "type organization should not be blank")
    private String type;
    @Schema(description = "Название организации")
    @NotBlank(message = "name organization should not be blank")
    private String name;
}
