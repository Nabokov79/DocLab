package ru.nabokov.dataservice.dto.measuringTool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MeasuringToolIds {

    private Long typeId;
    private Long organizationId;
    private Long userId;
    private Long manufacturerId;
    private Long ownerId;
}
