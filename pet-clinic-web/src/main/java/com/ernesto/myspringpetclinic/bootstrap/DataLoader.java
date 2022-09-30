package com.ernesto.myspringpetclinic.bootstrap;

import com.ernesto.myspringpetclinic.model.Owner;
import com.ernesto.myspringpetclinic.model.Vet;
import com.ernesto.myspringpetclinic.services.OwnerService;
import com.ernesto.myspringpetclinic.services.VetService;
import com.ernesto.myspringpetclinic.services.map.OwnerServiceMap;
import com.ernesto.myspringpetclinic.services.map.PetServiceMap;
import com.ernesto.myspringpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Agustin");
        owner1.setLastName("Laje");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Nicolas");
        owner2.setLastName("Marquez");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pablo");
        vet1.setLastName("Munoz");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ignacio");
        vet2.setLastName("Allende");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
        

    }
}
