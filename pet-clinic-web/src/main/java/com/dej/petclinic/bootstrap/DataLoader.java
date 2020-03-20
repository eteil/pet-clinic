package com.dej.petclinic.bootstrap;

import com.dej.petclinic.models.*;
import com.dej.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;
    private VisitService visitService;
    private PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }


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


        Owner o1 = Owner.builder().firstName("o1").lastName("o1").build();
        o1.setAddress("dla");
        o1.setCity("dla4");
        o1.setTelephone("6165165");

        Pet d1 = new Pet(dog, o1, LocalDate.now(), "d1");
        Pet c1 = new Pet(cat, o1, LocalDate.now(), "c1");

        o1.getPets().add(d1);
        o1.getPets().add(c1);



        ownerService.save(o1);

        Visit DVisist = new Visit();
        DVisist.setDate(LocalDate.now());
        DVisist.setDescription("visite du chien");
        DVisist.setPet(d1);

        Visit savedVisit = visitService.save(DVisist);
        System.out.println("visits loaded....");

        Owner o2 = Owner.builder().firstName("o2").lastName("o2").build();
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

        specialityService.save(s1);
        specialityService.save(s2);

        Vet v1 = new Vet("v1","v1");
        v1.getSpecialities().add(s1);

        vetService.save(v1);

        Vet v2 = new Vet("v2","v2");
        v2.getSpecialities().add(s2);

        vetService.save(v2);

        System.out.println("Vets loaded...");
    }
}
