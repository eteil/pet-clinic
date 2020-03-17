package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.Pet;
import com.dej.petclinic.repositories.PetRepo;
import com.dej.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class PetJPAService implements PetService {

    private final PetRepo petRepo;

    public PetJPAService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepo.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepo.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepo.deleteById(aLong);
    }

    @Override
    public void delete(Pet object) {
        petRepo.delete(object);
    }
}
