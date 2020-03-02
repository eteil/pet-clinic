package com.dej.petclinic.repositories;

import com.dej.petclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepo extends CrudRepository<Speciality, Long> {
}
