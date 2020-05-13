package com.yg.OnlineClinic.services;

import com.yg.OnlineClinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
