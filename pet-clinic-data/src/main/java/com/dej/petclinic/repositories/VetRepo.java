package com.dej.petclinic.repositories;

import com.dej.petclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet, Long> {
}
