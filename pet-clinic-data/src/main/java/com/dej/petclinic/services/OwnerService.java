package com.dej.petclinic.services;

import com.dej.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
