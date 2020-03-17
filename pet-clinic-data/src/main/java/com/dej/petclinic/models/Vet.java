package com.dej.petclinic.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "vets")
public class Vet extends Person{

    public Vet() {
    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "spec_id")
    )
    private Set<Speciality> specialities = new HashSet<>();

}
