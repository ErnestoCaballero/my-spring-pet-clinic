package com.ernesto.myspringpetclinic.repositories;

import com.ernesto.myspringpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
