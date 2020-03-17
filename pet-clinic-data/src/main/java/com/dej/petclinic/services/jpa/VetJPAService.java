package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.Vet;
import com.dej.petclinic.repositories.VetRepo;
import com.dej.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class VetJPAService implements VetService {

    private final VetRepo vetRepo;

    public VetJPAService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepo.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }
}
