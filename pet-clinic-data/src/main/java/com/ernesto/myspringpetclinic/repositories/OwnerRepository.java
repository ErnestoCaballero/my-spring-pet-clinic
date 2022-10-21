package com.ernesto.myspringpetclinic.repositories;

import com.ernesto.myspringpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.io.FileWriter;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);


}
