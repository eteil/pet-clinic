package com.dej.petclinic.bootstrap;

import com.dej.petclinic.models.*;
import com.dej.petclinic.services.OwnerService;
import com.dej.petclinic.services.PetTypeService;
import com.dej.petclinic.services.SpecialityService;
import com.dej.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VetService vetService;

    @Autowired
    private PetTypeService petTypeService;

    @Autowired
    private SpecialityService specialityService;


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();
    }

    public void loadData(){
        PetType dog = new PetType("dog");
        PetType savedDog = petTypeService.save(dog);


        PetType cat = new PetType("cat");
        PetType savedCat = petTypeService.save(cat);


        Owner o1 = new Owner("o1","o1");
        o1.setAddress("dla");
        o1.setCity("dla4");
        o1.setTelephone("6165165");

        Pet d1 = new Pet(dog, o1, LocalDate.now(), "d1");
        Pet c1 = new Pet(cat, o1, LocalDate.now(), "c1");

        o1.getPets().add(d1);
        o1.getPets().add(c1);

        ownerService.save(o1);

        Owner o2 = new Owner("o2", "o2");
        o2.setAddress("yde");
        o2.setCity("yde3");
        o2.setTelephone("6165165");

        Pet d2 = new Pet(dog, o2, LocalDate.now(), "d2");
        Pet d3 = new Pet(dog, o2, LocalDate.now(), "d3");

        o2.getPets().add(d2);
        o2.getPets().add(d3);

        ownerService.save(o2);

        System.out.println("Owners loaded...");

        Speciality s1 = new Speciality("s1");
        Speciality s2 = new Speciality("s2");

        Vet v1 = new Vet("v1","v1");
        v1.getSpecialities().add(s1);

        vetService.save(v1);

        Vet v2 = new Vet("v2","v2");
        v2.getSpecialities().add(s2);

        vetService.save(v2);

        System.out.println("Vets loaded...");
    }
}
