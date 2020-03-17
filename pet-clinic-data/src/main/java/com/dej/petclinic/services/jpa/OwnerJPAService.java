package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.Owner;
import com.dej.petclinic.repositories.OwnerRepo;
import com.dej.petclinic.repositories.PetRepo;
import com.dej.petclinic.repositories.PetTypeRepo;
import com.dej.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class OwnerJPAService implements OwnerService {

    private final OwnerRepo ownerRepo;
    private final PetRepo petRepo;
    private final PetTypeRepo petTypeRepo;

    @Autowired
    public OwnerJPAService(OwnerRepo ownerRepo, PetRepo petRepo, PetTypeRepo petTypeRepo) {
        this.ownerRepo = ownerRepo;
        this.petRepo = petRepo;
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners  = new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepo.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }
}
