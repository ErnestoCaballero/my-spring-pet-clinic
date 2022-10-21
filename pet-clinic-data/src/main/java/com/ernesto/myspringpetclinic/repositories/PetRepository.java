package com.ernesto.myspringpetclinic.repositories;

import com.ernesto.myspringpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
