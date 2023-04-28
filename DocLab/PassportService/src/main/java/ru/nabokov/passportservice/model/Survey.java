package ru.nabokov.passportservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "object_data_id")
    private Long objectDataId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "survey", nullable = false)
    private String survey;
    @Column(name = "number")
    private String number;
    @Column(name = "organization_id")
    private Long organizationId;
}
