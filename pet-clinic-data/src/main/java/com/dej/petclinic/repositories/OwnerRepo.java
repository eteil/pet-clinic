package com.dej.petclinic.repositories;

import com.dej.petclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
