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
@Table(name = "pipeline_norms")
public class PipelineNorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_id")
    private Long typeId;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "thickness")
    private Float thickness;
    @Column(name = "min")
    private Float min;
}
