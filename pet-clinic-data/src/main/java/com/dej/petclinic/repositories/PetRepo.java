package com.dej.petclinic.repositories;

import com.dej.petclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {
}
