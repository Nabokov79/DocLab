package ru.nabokov.passportservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ObjectDataDto {

    private long id;
    private TypeDto type;
    private String model;
    private Integer number;
    private Integer volume;
    private String orientation;
    private String place;
    private BuildingDto building;
}
