package com.dej.petclinic.bootstrap;

import com.dej.petclinic.models.Owner;
import com.dej.petclinic.models.Vet;
import com.dej.petclinic.services.OwnerService;
import com.dej.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VetService vetService;


    @Override
    public void run(String... args) throws Exception {


        Owner o1 = new Owner("o1","o1");
        o1.setId(1L);
        ownerService.save(o1);

        Owner o2 = new Owner("o2", "o2");
        o2.setId(2L);

        ownerService.save(o2);

        System.out.println("Owners loaded...");

        Vet v1 = new Vet("v1","v1");
        v1.setId(1L);

        vetService.save(v1);

        Vet v2 = new Vet("v2","v2");
        v2.setId(2L);

        vetService.save(v2);

        System.out.println("Vets loaded...");

    }
}
