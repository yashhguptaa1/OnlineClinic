package com.yg.OnlineClinic.services.springdatajpa;

import com.yg.OnlineClinic.model.Doctor;
import com.yg.OnlineClinic.repositories.DoctorRepository;
import com.yg.OnlineClinic.services.DoctorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DoctorSDJpaService implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorSDJpaService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Set<Doctor> findAll() {
        Set<Doctor>doctors=new HashSet<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    @Override
    public Doctor findById(Long aLong) {

        return doctorRepository.findById(aLong).orElse(null);
    }

    @Override
    public Doctor save(Doctor object) {
        return doctorRepository.save(object);
    }

    @Override
    public void delete(Doctor object) {

        doctorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        doctorRepository.deleteById(aLong);

    }
}
