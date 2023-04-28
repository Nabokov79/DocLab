package ru.nabokov.passportservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddressDto {

    private long id;
    private CityDto city;
    private String street;
    private Integer houseNumber;
    private Integer buildingNumber;
    private String letter;
}
