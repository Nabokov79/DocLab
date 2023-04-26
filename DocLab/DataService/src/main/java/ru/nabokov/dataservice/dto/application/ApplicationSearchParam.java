package ru.nabokov.dataservice.dto.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class ApplicationSearchParam {

    private Long addressId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean report;
    private Boolean protocol;
    private Long typeId;
}
