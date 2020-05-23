package com.yg.OnlineClinic.services.springdatajpa;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.repositories.GuardianRepository;
import com.yg.OnlineClinic.repositories.PetRepository;
import com.yg.OnlineClinic.repositories.PetTypeRepository;
import com.yg.OnlineClinic.services.GuardianService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class GuardianSDJpaService implements GuardianService {

    private final GuardianRepository guardianRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public GuardianSDJpaService(GuardianRepository guardianRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.guardianRepository = guardianRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Guardian findByLastName(String lastName) {
        return guardianRepository.findByLastName(lastName);
    }

    @Override
    public Set<Guardian> findAll() {

        Set<Guardian>guardians=new HashSet<>();
        guardianRepository.findAll().forEach(guardians::add);
        return guardians;

    }

    @Override
    public Guardian findById(Long aLong) {
        Optional<Guardian>optionalGuardian= guardianRepository.findById(aLong);

        return optionalGuardian.orElse(null);

    }

    @Override
    public Guardian save(Guardian object) {
        return guardianRepository.save(object);
    }

    @Override
    public void delete(Guardian object) {
        guardianRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        guardianRepository.deleteById(aLong);

    }

    @Override
    public List<Guardian> findAllByLastNameLike(String lastName) {
        return guardianRepository.findAllByLastNameLike(lastName);
    }
}







