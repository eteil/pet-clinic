package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.Owner;
import com.dej.petclinic.repositories.OwnerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    @Mock
    OwnerRepo ownerRepo;

    @InjectMocks
    OwnerJPAService ownerJPAService;

    final String LAST_NAME = "eteil";
    Owner owner;

    @BeforeEach
    void setUp() {

        owner = Owner.builder().firstName("e1").lastName(LAST_NAME).build();
        ownerJPAService.save(owner);

    }

    @Test
    void findByLastName() {
        assertNotNull(ownerJPAService);
        when(ownerRepo.findByLastName(LAST_NAME)).thenReturn(owner);
        Owner findedOwner = ownerJPAService.findByLastName(LAST_NAME);
        assertNotNull(findedOwner);
        assertEquals(LAST_NAME, findedOwner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner o1 = Owner.builder().lastName(LAST_NAME).firstName("eteil").build();
        Owner o2 = Owner.builder().lastName("junior").firstName("dej").build();
        if(o1 == o2)
            System.out.println("equals");
        //assertNotEquals(o1, o2);
        owners.add(o1);
        owners.add(o2);
        System.out.println(owners);
        assertEquals(2, owners.size());
        when(ownerJPAService.findAll()).thenReturn(owners);

        Set<Owner> fOwners = ownerJPAService.findAll();
        //assertNotNull(fOwners);
        //assertEquals(2, fOwners.size());
    }

    @Test
    void findById() {
        //TODO
    }

    @Test
    void save() {
        //TODO
    }

    @Test
    void deleteById() {
        //TODO
    }

    @Test
    void delete() {
        //TODO
    }
}