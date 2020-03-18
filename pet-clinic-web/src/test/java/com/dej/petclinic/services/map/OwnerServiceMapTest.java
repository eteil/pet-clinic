package com.dej.petclinic.services.map;

import com.dej.petclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long id = 4L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        Owner owner = new Owner("eteil", "junior");
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        Owner owner = ownerServiceMap.findAll().stream().findFirst().orElse(null);
        ownerServiceMap.delete(owner);
        assertNull(ownerServiceMap.findById(1L));
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        Owner owner = ownerServiceMap.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner savedOwner = ownerServiceMap.save(new Owner("eteil", "junior"));
        assertNotNull(savedOwner);
        assertEquals("eteil", savedOwner.getFirstName());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);

        assertNotNull(owner);
        assertEquals(1L, owner.getId());

    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("junior");
        assertNotNull(owner);
    }
}