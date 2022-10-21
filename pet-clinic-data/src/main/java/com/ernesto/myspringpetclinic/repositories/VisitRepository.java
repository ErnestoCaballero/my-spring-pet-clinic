package com.ernesto.myspringpetclinic.repositories;

import com.ernesto.myspringpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
