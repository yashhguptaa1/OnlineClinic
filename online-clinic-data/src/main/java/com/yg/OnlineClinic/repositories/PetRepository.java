package com.yg.OnlineClinic.repositories;

import com.yg.OnlineClinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
