package com.yg.OnlineClinic.services;

import com.yg.OnlineClinic.model.Doctor;

import java.util.Set;

public interface DoctorService {

    Doctor findById(Long id);
    Doctor save(Doctor doctor);
    Set<Doctor> findAll();
}
