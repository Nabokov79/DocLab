package ru.nabokov.dataservice.model;

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
@Table(name = "object_data")
public class ObjectData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @Column(name = "model")
    private String model;
    @Column(name = "number")
    private Integer number;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "orientation")
    private String orientation;
    @Column(name = "place")
    private String place;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;
}
