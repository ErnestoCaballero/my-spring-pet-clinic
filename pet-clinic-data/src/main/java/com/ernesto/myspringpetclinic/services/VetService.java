package com.ernesto.myspringpetclinic.services;

import com.ernesto.myspringpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
