package com.ernesto.myspringpetclinic.services;

import com.ernesto.myspringpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
