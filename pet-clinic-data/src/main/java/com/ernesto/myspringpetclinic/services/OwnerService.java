package com.ernesto.myspringpetclinic.services;

import com.ernesto.myspringpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
