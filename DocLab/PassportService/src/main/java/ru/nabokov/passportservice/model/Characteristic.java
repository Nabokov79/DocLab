package ru.nabokov.passportservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "characteristics")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "subheading_id")
    private Long subheadingId;
    @Column(name = "meaning")
    private String meaning;
    @ManyToOne
    @JoinColumn(name = "passport_id")
    @JsonIgnore
    private Passport passport;
}
