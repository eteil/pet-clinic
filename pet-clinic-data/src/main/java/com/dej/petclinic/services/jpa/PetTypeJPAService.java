package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.PetType;
import com.dej.petclinic.repositories.PetTypeRepo;
import com.dej.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class PetTypeJPAService implements PetTypeService {

    private final PetTypeRepo petTypeRepo;

    public PetTypeJPAService(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepo.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepo.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepo.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepo.delete(object);
    }
}
