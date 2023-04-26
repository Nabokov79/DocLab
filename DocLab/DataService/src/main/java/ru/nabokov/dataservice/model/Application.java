package ru.nabokov.dataservice.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column(name = "work")
    private String work;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_data_id", referencedColumnName = "id")
    private ObjectData objectData;
    @Column(name = "primary_data")
    private LocalDate primaryData;
    @Column(name = "repeat_data")
    private LocalDate repeatData;
    @Column(name = "note")
    private String note;
    @Column(name = "report")
    private Boolean report;
    @Column(name = "protocol")
    private Boolean protocol;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "applications_employees",
            joinColumns =  {@JoinColumn(name = "application_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    @ToString.Exclude
    private List<Employee> employees;
}
