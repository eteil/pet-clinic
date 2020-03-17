package com.dej.petclinic.services.jpa;

import com.dej.petclinic.models.Visit;
import com.dej.petclinic.repositories.VisitRepo;
import com.dej.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class VisitJPAService implements VisitService {

    private final VisitRepo visitRepo;

    public VisitJPAService(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepo.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepo.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {

        visitRepo.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {

        visitRepo.delete(object);
    }
}
