package com.ernesto.myspringpetclinic.services.map;

import com.ernesto.myspringpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;

    Long idValue = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(idValue).build());
    }


    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertEquals(1, petSet.size());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(idValue);
        assertEquals(idValue, pet.getId());
    }

    @Test
    void save() {
        Long id = 3L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(pet2);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(idValue));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(idValue);
        assertEquals(0, petMapService.findAll().size());
    }
}