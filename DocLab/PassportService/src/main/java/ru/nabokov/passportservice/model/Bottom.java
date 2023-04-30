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
@Table(name = "bottoms")
public class Bottom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_id")
    private Long typeId;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "name")
    private String name;
    @Column(name = "thickness")
    private Integer thickness;
    @Column(name = "min")
    private Float min;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "edge_id", referencedColumnName = "id")
    private Edge edge;
}
