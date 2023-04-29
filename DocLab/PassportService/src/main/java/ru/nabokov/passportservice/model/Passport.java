package ru.nabokov.passportservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "project_number")
    private String projectNumber;
    @Column(name = "manufacturer_id")
    private Long manufacturerId;
    @Column(name = "mounting_id")
    private Long mountingId;
    @Column(name = "manufacture")
    private String manufacture;
    @Column(name = "installation")
    private LocalDate installation;
    @Column(name = "operation")
    private LocalDate operation;
    @Column(name = "start_passport")
    private LocalDate startPassport;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dimension_id", referencedColumnName = "id")
    private Dimensions dimension;
    @Column(name = "height_pipe")
    private Float heightPipe;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "protection_id", referencedColumnName = "id")
    private Protection protection;
    @Column(name = "estimated_life")
    private Integer estimatedLife;
    @Column(name = "pressure")
    private Integer pressure;
    @Column(name = "direct_pressure")
    private String directPressure;
    @Column(name = "direct_temperature")
    private String directTemperature;
    @Column(name = "back_pressure")
    private String backPressure;
    @Column(name = "back_temperature")
    private String backTemperature;
    @Column(name = "temperature")
    private String temperature;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_bottoms",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "bottom_id")})
    @ToString.Exclude
    private List<Bottom> bottoms;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_belts",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "belt_id")})
    @ToString.Exclude
    private List<Belt> belts;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_pipeline_norms",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "pipeline_norm_id")})
    @ToString.Exclude
    private List<PipelineNorm> pipelineNorms;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_surveys",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "surveys_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_repairs",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repairs_id")})
    @ToString.Exclude
    private List<Repair> repairs;
}
