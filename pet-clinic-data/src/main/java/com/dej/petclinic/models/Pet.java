package com.dej.petclinic.models;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"owner", "visits"})
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate localDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet() {
    }

    public Pet(PetType petType, Owner owner, LocalDate localDate, String name) {
        this.petType = petType;
        this.owner = owner;
        this.localDate = localDate;
        this.name = name;
    }


}
