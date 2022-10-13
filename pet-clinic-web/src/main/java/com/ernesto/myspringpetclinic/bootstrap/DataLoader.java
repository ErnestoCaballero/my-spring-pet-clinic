package com.ernesto.myspringpetclinic.bootstrap;

import com.ernesto.myspringpetclinic.model.Owner;
import com.ernesto.myspringpetclinic.model.Pet;
import com.ernesto.myspringpetclinic.model.PetType;
import com.ernesto.myspringpetclinic.model.Vet;
import com.ernesto.myspringpetclinic.services.OwnerService;
import com.ernesto.myspringpetclinic.services.PetTypeService;
import com.ernesto.myspringpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Pablo");
        vet1.setLastName("Munoz");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ignacio");
        vet2.setLastName("Allende");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
