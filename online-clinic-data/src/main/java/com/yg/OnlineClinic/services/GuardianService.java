package com.yg.OnlineClinic.services;

import com.yg.OnlineClinic.model.Guardian;

import java.util.Set;

public interface GuardianService {

    Guardian findById(Long id);
    Guardian findByLastName(String lastName);
    Guardian save(Guardian guardian);
    Set<Guardian>findAll();
}
