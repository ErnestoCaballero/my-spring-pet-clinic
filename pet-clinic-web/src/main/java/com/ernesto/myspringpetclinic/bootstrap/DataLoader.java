package com.ernesto.myspringpetclinic.bootstrap;

import com.ernesto.myspringpetclinic.model.*;
import com.ernesto.myspringpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Agustin");
        owner1.setLastName("Laje");
        owner1.setAddress("De la plata 123");
        owner1.setCity("Cordoba");
        owner1.setTelephone("1231231234");

        Pet agustinPet = new Pet();
        agustinPet.setPetType(saveDogPetType);
        agustinPet.setOwner(owner1);
        agustinPet.setBirthDate(LocalDate.now());
        agustinPet.setName("Marx");
        owner1.getPets().add(agustinPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nicolas");
        owner2.setLastName("Marquez");
        owner2.setAddress("De la plata 123");
        owner2.setCity("Cordoba");
        owner2.setTelephone("4324324321");

        Pet nicolasCat = new Pet();
        nicolasCat.setName("Guevara");
        nicolasCat.setOwner(owner2);
        nicolasCat.setBirthDate(LocalDate.now());
        nicolasCat.setPetType(saveCatPetType);
        owner2.getPets().add(nicolasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(nicolasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Pablo");
        vet1.setLastName("Munoz");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ignacio");
        vet2.setLastName("Allende");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
