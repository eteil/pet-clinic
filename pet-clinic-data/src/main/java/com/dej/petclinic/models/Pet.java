package com.dej.petclinic.models;


import java.time.LocalDate;

public class Pet extends BaseEntity{

    private PetType petType;
    private Owner owner;
    private LocalDate localDate;

    public Pet() {
    }

    public Pet(PetType petType, Owner owner, LocalDate localDate) {
        this.petType = petType;
        this.owner = owner;
        this.localDate = localDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
