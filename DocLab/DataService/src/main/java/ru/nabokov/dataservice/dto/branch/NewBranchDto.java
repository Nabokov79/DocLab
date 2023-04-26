package ru.nabokov.dataservice.dto.branch;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового подразделения")
public class NewBranchDto {

    @Schema(description = "Название филиала")
    @NotBlank(message = "branch should not be blank")
    private String branch;
    @Schema(description = "Название подразделения")
    @NotBlank(message = "division should not be blank")
    private String division;
    @Schema(description = "Индентификатор адреса")
    @NotNull(message = "city id should not be blank")
    @Positive(message = "city id must be positive")
    private Long addressId;
    @Schema(description = "Почтовый индекс")
    @NotNull(message = "index should not be blank")
    @Positive(message = "index must be positive")
    private Integer index;
    @Schema(description = "Номер телефона")
    @NotBlank(message = "phone should not be blank")
    private String phone;
    @Schema(description = "Факс")
    @NotBlank(message = "fax should not be blank")
    private String fax;
    @Schema(description = "электронная почта")
    @NotBlank(message = "email should not be blank")
    @Email(message = "email invalid")
    private String email;
    @Schema(description = "Индентификатор лицензии")
    @NotNull(message = "license id should not be blank")
    @Positive(message = "license id must be positive")
    private Long licenseId;
}
