package com.dej.petclinic.models;

public class Speciality extends BaseEntity {

    private String description;
    private String name;

    public Speciality(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
