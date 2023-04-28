package ru.nabokov.passportservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BuildingDto {

    private long id;
    private AddressDto address;
    private String building;
    private String branch;
    private String login;
}
