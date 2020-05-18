package com.yg.OnlineClinic.repositories;

import com.yg.OnlineClinic.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
