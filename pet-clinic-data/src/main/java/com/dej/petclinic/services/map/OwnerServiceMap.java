package com.dej.petclinic.services.map;

import com.dej.petclinic.models.Owner;
import com.dej.petclinic.models.Pet;
import com.dej.petclinic.services.OwnerService;
import com.dej.petclinic.services.PetService;
import com.dej.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long>  implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object.getPets() != null){
            object.getPets().forEach(pet -> {
                if (pet.getPetType() != null){
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }else{
                    throw new RuntimeException(("PetType is required"));
                }
                if (pet.getId() == null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        object.setId(super.getNextId());
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }


}
