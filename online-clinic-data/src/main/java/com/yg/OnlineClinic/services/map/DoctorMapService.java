package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.Doctor;
import com.yg.OnlineClinic.model.Speciality;
import com.yg.OnlineClinic.services.DoctorService;
import com.yg.OnlineClinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class DoctorMapService extends AbstractMapService<Doctor,Long> implements DoctorService {

    private final SpecialityService specialityService;

    public DoctorMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if(object.getSpecialities().size()>0)
        {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpeciality=specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
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
