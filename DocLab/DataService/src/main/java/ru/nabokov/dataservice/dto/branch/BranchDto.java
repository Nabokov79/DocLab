package ru.nabokov.dataservice.dto.branch;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.dataservice.model.Address;
import ru.nabokov.dataservice.model.License;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового подразделения")
public class BranchDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название филиала")
    private String branch;
    @Schema(description = "Название подразделения")
    private String division;
    @Schema(description = "Адрес")
    private Address address;
    @Schema(description = "Почтовый индекс")
    private Integer index;
    @Schema(description = "Номер телефона")
    private String phone;
    @Schema(description = "Факс")
    private String fax;
    @Schema(description = "Электронная почта")
    private String email;
    @Schema(description = "Лицензия")
    private License license;
}
