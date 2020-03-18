package com.dej.petclinic.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("eteil","junior");
    }

    @Test
    void getFirstName() {
        String fn = "eteil";
        assertEquals(fn, person.getFirstName());
    }
}