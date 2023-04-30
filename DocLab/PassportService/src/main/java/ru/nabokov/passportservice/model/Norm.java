package ru.nabokov.passportservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "norms")
public class Norm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "object_data_id")
    private Long objectDataId;
    @Column(name = "type_id")
    private Long typeId;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "norms_bottoms",
            joinColumns =  {@JoinColumn(name = "norm_id")},
            inverseJoinColumns = {@JoinColumn(name = "bottom_id")})
    @ToString.Exclude
    private List<Bottom> bottoms;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "norms_belts",
            joinColumns =  {@JoinColumn(name = "norm_id")},
            inverseJoinColumns = {@JoinColumn(name = "belt_id")})
    @ToString.Exclude
    private List<Belt> belts;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "norms_pipeline_norms",
            joinColumns =  {@JoinColumn(name = "norm_id")},
            inverseJoinColumns = {@JoinColumn(name = "pipeline_norm_id")})
    @ToString.Exclude
    private List<PipelineNorm> pipelineNorms;
}
