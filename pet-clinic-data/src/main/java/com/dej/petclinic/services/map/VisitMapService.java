package com.dej.petclinic.services.map;

import com.dej.petclinic.models.Pet;
import com.dej.petclinic.models.Visit;
import com.dej.petclinic.services.PetService;
import com.dej.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit object) {
        //check if there is a pet asociated to the visit
        if (object.getPet() != null){
            if (object.getPet().getId() == null){
                Pet savedPet = petService.save(object.getPet());
                object.getPet().setId(savedPet.getId());
            }
        }else {
            throw new RuntimeException("there must be a pet");
        }
        object.setId(super.getNextId());

        return super.save(object.getId(), object);
    }

    @Override
    public void deleteById(Long aLong) {

        super.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {

        super.delete(object);
    }
}
