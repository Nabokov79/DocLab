package ru.nabokov.passportservice.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_id")
    private Long typeId;
    @Column(name = "object_data_id")
    private Long objectDataId;
    @OneToMany(mappedBy = "passport", fetch = FetchType.LAZY)
    private List<Characteristic> characteristics;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_surveys",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "survey_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_repairs",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repair_id")})
    @ToString.Exclude
    private List<Repair> repairs;
}
