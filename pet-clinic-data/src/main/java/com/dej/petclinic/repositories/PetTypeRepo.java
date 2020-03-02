package com.dej.petclinic.repositories;

import com.dej.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
