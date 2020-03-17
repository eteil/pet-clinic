package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.Speciality;
import com.dej.petclinic.repositories.SpecialityRepo;
import com.dej.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class SpeJPAService implements SpecialityService {

    private final SpecialityRepo specialityRepo;

    public SpeJPAService(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepo.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepo.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepo.deleteById(aLong);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepo.delete(object);
    }
}
