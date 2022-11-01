package com.ernesto.myspringpetclinic.services.map;

import com.ernesto.myspringpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;

    Long[] idValues = {1L, 2L, 3L};
    int typesSize = idValues.length;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        for (Long l : idValues) {
            petTypeMapService.save(PetType.builder().id(l).build());
        }
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = petTypeMapService.findAll();
        assertEquals(typesSize, petTypeSet.size());
    }

    @Test
    void findById() {
        Long idToFind = 3L;
        PetType petType = petTypeMapService.findById(idToFind);
        assertEquals(idToFind, petType.getId());
    }

    @Test
    void save() {
        Long newId = 4L;
        PetType petType = PetType.builder().id(newId).build();
        PetType savedPetType = petTypeMapService.save(petType);
        assertEquals(newId, savedPetType.getId());
    }

    @Test
    void delete() {
        int idToDelete = 0;
        petTypeMapService.delete(petTypeMapService.findById(idValues[idToDelete]));
        assertEquals(idValues.length-1, petTypeMapService.findAll().size());
    }

    @Test
    void deleteById() {
        Long idToDelete = 2L;
        petTypeMapService.deleteById(idToDelete);
        for (Long l : idValues) {
            if (l == idToDelete) {
                assertNull(petTypeMapService.findById(idToDelete));
            } else {
                assertEquals(l, petTypeMapService.findById(l).getId());
            }
        }
    }
}