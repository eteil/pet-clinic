package com.dej.petclinic.repositories;

import com.dej.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
