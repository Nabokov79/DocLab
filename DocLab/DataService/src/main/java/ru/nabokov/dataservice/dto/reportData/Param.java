package ru.nabokov.dataservice.dto.reportData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class Param {

    private Long objectDataId;
    private Long employeeId;
    private Long addressId;
    private Integer number;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
