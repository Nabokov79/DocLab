package ru.nabokov.passportservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "belts")
public class Belt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "thickness")
    private Integer thickness;
    @Column(name = "min")
    private Float min;
    @Column(name = "volume")
    private Integer volume;
}
