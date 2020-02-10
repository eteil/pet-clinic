package com.dej.petclinic.services.map;

import com.dej.petclinic.models.Speciality;
import com.dej.petclinic.models.Vet;
import com.dej.petclinic.services.SpecialityService;
import com.dej.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities() != null){
            object.getSpecialities().forEach(spe -> {
                if(spe.getId() == null){
                    Speciality savedSpe = specialityService.save(spe);
                    spe.setId(savedSpe.getId());
                }
            });
        }
        object.setId(super.getNextId());
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
