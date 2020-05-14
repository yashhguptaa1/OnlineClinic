package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.services.GuardianService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GuardianMapService extends AbstractMapService<Guardian,Long> implements GuardianService {
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
        return super.save(object.getId(),object);
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
