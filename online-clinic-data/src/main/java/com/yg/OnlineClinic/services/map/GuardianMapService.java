package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.model.Pet;
import com.yg.OnlineClinic.services.GuardianService;
import com.yg.OnlineClinic.services.PetService;
import com.yg.OnlineClinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GuardianMapService extends AbstractMapService<Guardian,Long> implements GuardianService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public GuardianMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Guardian> findAll() {
        return super.findAll();
    }

    @Override
    public Guardian findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Guardian save(Guardian object) {

        if(object!=null)
        {
            if(object.getPets()!=null)
            {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null)
                    {
                        if(pet.getPetType().getId()==null)
                        {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    }else
                        throw new RuntimeException("Pet type is req");

                    if(pet.getId()==null)
                    {
                        Pet savedPet=petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);

        }
        else
            return null;

    }

    @Override
    public Guardian findByLastName(String lastName) {
        return null;
    }

    @Override
    public void delete(Guardian object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
