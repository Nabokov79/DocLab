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
@Table(name = "dimensions")
public class Dimensions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "height")
    private Integer height;
    @Column(name = "length")
    private Integer length;
    @Column(name = "diameter")
    private Integer diameter;

}
