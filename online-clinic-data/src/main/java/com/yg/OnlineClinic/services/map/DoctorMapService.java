package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.Doctor;
import com.yg.OnlineClinic.services.DoctorService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DoctorMapService extends AbstractMapService<Doctor,Long> implements DoctorService {


    @Override
    public Set<Doctor> findAll() {
        return super.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Doctor save(Doctor object) {
        return super.save(object);
    }

    @Override
    public void delete(Doctor object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
