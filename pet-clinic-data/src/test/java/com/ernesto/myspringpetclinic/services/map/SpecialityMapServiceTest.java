package com.ernesto.myspringpetclinic.services.map;

import com.ernesto.myspringpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    SpecialityMapService specialityMapService;

    final Long specialityId = 3L;
    final String description = "Cardiology";


    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().id(specialityId).description(description).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialitySet = specialityMapService.findAll();
        assertEquals(1, specialitySet.size());
    }

    @Test
    void findById() {
        Speciality speciality = specialityMapService.findById(specialityId);
        assertEquals(specialityId, speciality.getId());
    }

    @Test
    void save() {
        Long id = 2L;
        Speciality speciality2 = Speciality.builder().id(id).build();
        Speciality savedSpeciality = specialityMapService.save(speciality2);
        assertEquals(id, savedSpeciality.getId());
    }

    @Test
    void delete() {
        specialityMapService.delete(specialityMapService.findById(specialityId));
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(specialityId);
        assertEquals(0, specialityMapService.findAll().size());
    }
}