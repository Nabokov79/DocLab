package ru.nabokov.passportservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DimensionDto {

    private Integer height;
    private Integer length;
    private Integer diameter;
}
