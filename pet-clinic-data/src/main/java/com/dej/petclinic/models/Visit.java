package com.dej.petclinic.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(exclude = {"pet"})
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date_visit")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
